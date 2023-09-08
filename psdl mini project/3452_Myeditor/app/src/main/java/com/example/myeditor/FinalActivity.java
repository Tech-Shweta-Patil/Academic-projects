package com.example.myeditor;

import static com.example.myeditor.MainActivity.imgUri;

import androidx.appcompat.app.AppCompatActivity;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.myeditor.MainActivity;
import com.example.myeditor.databinding.ActivityFinal2Binding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.net.Uri;

public class FinalActivity extends AppCompatActivity {
    ActivityFinal2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFinal2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Toast.makeText(this, imgUri.toString(), Toast.LENGTH_SHORT).show();
        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);

        dsPhotoEditorIntent.setData(imgUri);
        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, " ");
//        int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
//
//        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);

        startActivityForResult(dsPhotoEditorIntent, 200);


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case 200:

                    Uri outputUri = data.getData();

                    // handle the result uri as you want, such as display it in an imageView;


                    binding.imgVIew.setImageURI(outputUri);
                    break;

            }

        }

    }
}