package com.bridgelabz.newipl.utility;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by bridgeit007 on 23/11/16.
 */

public class Imagedownload {
    public static Bitmap bitmap;

    public static void imageDownload(String uri, final ImageDownloaderInterface callback) {


        StorageReference mystorage = FirebaseStorage.getInstance().getReference();
        // Pointing to root node
        mystorage = mystorage.getRoot();
        // Taking url from model

        mystorage = mystorage.child(uri);

        /*//Method for Downloading the image
        final long ONE_MEGABYTE = 1024 * 1024;
        mystorage.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Converting bytes array to Bitmap
                  bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                // Setting the image to our view
                callback.imagaeDownloded(bitmap);
            }
        });*/

        mystorage.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
                callback.imagaeDownloded(uri);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }




}
