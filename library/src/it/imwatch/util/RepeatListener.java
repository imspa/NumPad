package it.imwatch.util;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

/**
 * A class, that can be used as a TouchListener on any view (e.g. a Button).
 * It cyclically runs a clickListener, emulating keyboard-like behaviour. First
 * click is fired immediately, next after mInitialInterval, and subsequent after
 * mNormalInterval.
 * <p/>
 * Interval is scheduled after the onClick completes, so it has to run fast.
 * If it runs slow, it does not generate skipped onClicks.
 */
public class RepeatListener implements OnTouchListener {

    private final Handler mHandler = new Handler();

    private int mInitialInterval;
    private final int mNormalInterval;
    private final OnClickListener mOnClickListener;

    private final Runnable handlerRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this, mNormalInterval);
            mOnClickListener.onClick(mDownView);
        }
    };

    private View mDownView;

    /**
     * Initialize an instance of the RepeatListener.
     *
     * @param initialInterval The interval after first click event
     * @param normalInterval  The interval after second and subsequent click
     *                        events
     * @param clickListener   The OnClickListener, that will be called
     *                        periodically
     */
    public RepeatListener(int initialInterval, int normalInterval,
                          OnClickListener clickListener) {
        if (clickListener == null) {
            throw new IllegalArgumentException("null runnable");
        }
        if (initialInterval < 0 || normalInterval < 0) {
            throw new IllegalArgumentException("negative interval");
        }

        mInitialInterval = initialInterval;
        mNormalInterval = normalInterval;
        mOnClickListener = clickListener;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mHandler.removeCallbacks(handlerRunnable);
                mHandler.postDelayed(handlerRunnable, mInitialInterval);
                mDownView = view;
                mOnClickListener.onClick(view);
                break;
            case MotionEvent.ACTION_UP:
                mHandler.removeCallbacks(handlerRunnable);
                mDownView = null;
                break;
        }
        return false;
    }

}