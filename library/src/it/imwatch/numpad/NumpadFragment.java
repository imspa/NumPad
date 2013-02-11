package it.imwatch.numpad;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import it.imwatch.util.RepeatListener;

import java.util.ArrayList;

/** A numeric input pad. */
public class NumpadFragment extends Fragment {

    /** The max number of numbers/symbols you can write in the numpad. */
    public static final int MAX_NUMBER_SIZE = 16;
    private static final int INITIAL_INTERVAL = 400;
    private static final int NORMAL_INTERVAL = 150;

    final ArrayList<Character> mNumber = new ArrayList<Character>();
    TextView numberView;

    private OnCallListener mCallListener = null;


    /** Interface definition for a callback to be invoked when the button CALLED is called. */
    public interface OnCallListener {
        public void onCall(String number);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_numpad, null);

        Typeface externalFont = Typeface.createFromAsset(getActivity().getAssets(), "Roboto-Regular.ttf");

        Button btn1 = (Button) view.findViewById(R.id.btn1);
        btn1.setTypeface(externalFont);
        Button btn2 = (Button) view.findViewById(R.id.btn2);
        btn2.setTypeface(externalFont);
        Button btn3 = (Button) view.findViewById(R.id.btn3);
        btn3.setTypeface(externalFont);
        Button btn4 = (Button) view.findViewById(R.id.btn4);
        btn4.setTypeface(externalFont);
        Button btn5 = (Button) view.findViewById(R.id.btn5);
        btn5.setTypeface(externalFont);
        Button btn6 = (Button) view.findViewById(R.id.btn6);
        btn6.setTypeface(externalFont);
        Button btn7 = (Button) view.findViewById(R.id.btn7);
        btn7.setTypeface(externalFont);
        Button btn8 = (Button) view.findViewById(R.id.btn8);
        btn8.setTypeface(externalFont);
        Button btn9 = (Button) view.findViewById(R.id.btn9);
        btn9.setTypeface(externalFont);

        ImageButton btnCanc = (ImageButton) view.findViewById(R.id.btnCanc);

        Button btnZero = (Button) view.findViewById(R.id.btnZero);
        btnZero.setTypeface(externalFont);

        ImageButton btnCall = (ImageButton) view.findViewById(R.id.btnCall);

        numberView = (TextView) view.findViewById(R.id.numbernumber);
        numberView.setTypeface(externalFont);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('1'); }
        });
        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('2'); }
        });
        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('3'); }
        });

        btn4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('4'); }
        });
        btn5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('5'); }
        });
        btn6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('6'); }
        });

        btn7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('7'); }
        });
        btn7.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pushToNumber('*');
                return true;
            }
        });

        btn8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('8'); }
        });

        btn9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { pushToNumber('9'); }
        });
        btn9.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pushToNumber('#');
                return true;
            }
        });

        btnCanc.setOnTouchListener(new RepeatListener(INITIAL_INTERVAL, NORMAL_INTERVAL,
                                                      new OnClickListener() {
                                                          @Override
                                                          public void onClick(View v) {
                                                              popFromNumber();
                                                          }
                                                      }));

        btnZero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {pushToNumber('0'); }
        });
        btnZero.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pushToNumber('+');
                return true;
            }
        });

        btnCall.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallListener != null) {
                    mCallListener.onCall(numberToString());
                }
            }
        });

        return view;
    }

    /**
     * Gets the current Call button onClick listener.
     *
     * @return Returns the Call button onClick listener
     */
    public OnCallListener getCallListener() {
        return mCallListener;
    }

    /**
     * Set a new Call button onClick listener.
     *
     * @param listener The new Call button onClick listener
     */
    public void setCallListener(OnCallListener listener) {
        mCallListener = listener;
    }

    private void pushToNumber(char c) {
        if (mNumber.size() < MAX_NUMBER_SIZE) {
            mNumber.add(c);
            numberView.setText(numberToString());
        }
    }

    private void popFromNumber() {
        if (!mNumber.isEmpty()) {
            mNumber.remove(mNumber.size() - 1);
            numberView.setText(numberToString());
        }
    }

    private String numberToString() {
        StringBuilder builder = new StringBuilder(mNumber.size());
        for (Character ch : mNumber) {
            builder.append(ch);
        }
        return builder.toString();
    }

}
