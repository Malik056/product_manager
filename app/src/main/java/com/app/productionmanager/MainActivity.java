package com.app.productionmanager;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

import static androidx.core.content.PermissionChecker.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {
    OutputStream fo = null;
    private static final int WritePermissionCode = 2001;
    MaterialButton start;
    MaterialButton c1;
    MaterialButton c2;
    MaterialButton c3;
    MaterialButton in;
    MaterialButton out;
    MaterialButton newFile;
    MaterialButton exit;
    boolean firstEntry = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.startBtn);
        c1 = findViewById(R.id.c1Btn);
        c2 = findViewById(R.id.c2Btn);
        c3 = findViewById(R.id.c3Btn);
        in = findViewById(R.id.inBtn);
        out = findViewById(R.id.outBtn);
        newFile = findViewById(R.id.newFileBtn);
        exit = findViewById(R.id.exitBtn);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WritePermissionCode);
        } else {
            init();
        }
    }

    private void init() {
        start.setOnClickListener(view -> {
            if (!firstEntry) {
                try {
                    fo.write(", ".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                firstEntry = false;
            }
            DateTime now = DateTime.now(DateTimeZone.UTC);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withZone(DateTimeZone.getDefault());
            String date = formatter.print(now);
            String toPrint = date + " Start";
            Log.d("PrintDate", date + " Start");
            try {
                fo.write(toPrint.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        newFile.setEnabled(false);
        newFile.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.PreferenceDialogLight);
            builder.setTitle("Enter file name");
            // Set up the input
            final EditText input = new EditText(getApplicationContext());
            input.setTextColor(getResources().getColor(R.color.black));
            setCursorColor(input, getResources().getColor(R.color.black));
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.setOnShowListener(dialogInterface -> {
                Button button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                button.setTextColor(getResources().getColor(R.color.black));
                button.setOnClickListener(view2 -> {
                    String m_Text = input.getText().toString();
                    if (m_Text.isEmpty()) {
                        input.setError("Please enter file name");
                    } else {
                        if (createFile(m_Text)) {
                            start.setEnabled(true);
                            c1.setEnabled(true);
                            c2.setEnabled(true);
                            c3.setEnabled(true);
                            in.setEnabled(true);
                            out.setEnabled(true);
                            dialog.dismiss();
                        } else {
                            input.setError("Error Occurred");
                        }
                    }
                });

            });
            dialog.show();
        });

        c1.setOnClickListener(view -> {
            if (!firstEntry) {
                try {
                    fo.write(", ".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                firstEntry = false;
            }
            DateTime now = DateTime.now(DateTimeZone.UTC);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withZone(DateTimeZone.getDefault());
            String date = formatter.print(now);
            String toPrint = date + " C1";
            Log.d("PrintDate", date + " C1");
            try {
                fo.write(toPrint.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        c2.setOnClickListener(view -> {
            if (!firstEntry) {
                try {
                    fo.write(", ".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                firstEntry = false;
            }
            DateTime now = DateTime.now(DateTimeZone.UTC);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withZone(DateTimeZone.getDefault());
            String date = formatter.print(now);
            String toPrint = date + " C2";
            Log.d("PrintDate", date + " C2");
            try {
                fo.write(toPrint.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        c3.setOnClickListener(view -> {
            if (!firstEntry) {
                try {
                    fo.write(", ".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                firstEntry = false;
            }
            DateTime now = DateTime.now(DateTimeZone.UTC);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withZone(DateTimeZone.getDefault());
            String date = formatter.print(now);
            String toPrint = date + " C3";
            Log.d("PrintDate", date + " C3");
            try {
                fo.write(toPrint.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        in.setOnClickListener(view -> {
            if (!firstEntry) {
                try {
                    fo.write(", ".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                firstEntry = false;
            }
            DateTime now = DateTime.now(DateTimeZone.UTC);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withZone(DateTimeZone.getDefault());
            String date = formatter.print(now);
            String toPrint = date + " In";
            Log.d("PrintDate", date + " In");
            try {
                fo.write(toPrint.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        out.setOnClickListener(view -> {
            if (!firstEntry) {
                try {
                    fo.write(", ".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                firstEntry = false;
            }
            DateTime now = DateTime.now(DateTimeZone.UTC);
            DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy hh:mm:ss aa").withZone(DateTimeZone.getDefault());
            String date = formatter.print(now);
            String toPrint = date + " Out";
            Log.d("PrintDate", date + " Out");
            try {
                fo.write(toPrint.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        exit.setOnClickListener(view -> {
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finishAffinity();
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == WritePermissionCode) {
            if (grantResults[0] == PERMISSION_GRANTED) {
                init();
            } else {
                Toast.makeText(this, "Permission Denied! Exiting app", Toast.LENGTH_LONG).show();
                finishAffinity();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private boolean createFile(String name) {
        firstEntry = true;
        if (fo != null) {
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            String collection = "content://media/external/file"; // One can even write to micro SD card
            String relative_path = "Documents/Production Marker";

            Uri collectionUri = Uri.parse(collection);

            ContentValues contentValues = new ContentValues();
            String extension = "";
            if (!name.endsWith(".csv")) {
                extension = ".csv";
            }
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, relative_path);
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, name + extension);
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "csv");
            contentValues.put(MediaStore.MediaColumns.IS_PENDING, 1);

            Uri fileUri = getContentResolver().insert(collectionUri, contentValues);
            try {
                fo = getContentResolver().openOutputStream(fileUri);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS + "/Production Marker");
            if (!dir.exists()) {
                if (dir.mkdirs()) {
                    Log.d("DIR STATUS", "DIR  Created");
                }
            }
            String extension = "";
            if (!name.endsWith(".csv")) {
                extension = ".csv";
            }
            File file = new File(dir, name + extension);

            try {
                fo = new FileOutputStream(file, false); // true will be same as Context.MODE_APPEND
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
//            if (file.exists()) {
//                try {
//                    fo = new FileOutputStream(file);
//                    return true;
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                    return false;
//                }
//            } else {
//                try {
//                    boolean result = file.createNewFile();
//                    if (result) {
//                        fo = new FileOutputStream(file);
//                        return true;
//                    } else {
//                        return false;
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return false;
//                }
//            }
        }
    }

    public static void setCursorColor(EditText view, @ColorInt int color) {
        try {
            // Get the cursor resource id
            Field field = TextView.class.getDeclaredField("mCursorDrawableRes");
            field.setAccessible(true);
            int drawableResId = field.getInt(view);

            // Get the editor
            field = TextView.class.getDeclaredField("mEditor");
            field.setAccessible(true);
            Object editor = field.get(view);

            // Get the drawable and set a color filter
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), drawableResId);
            assert drawable != null;
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            Drawable[] drawables = {drawable, drawable};

            // Set the drawables
            assert editor != null;
            field = editor.getClass().getDeclaredField("mCursorDrawable");
            field.setAccessible(true);
            field.set(editor, drawables);
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void onDestroy() {
        if (fo != null) {
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }
}