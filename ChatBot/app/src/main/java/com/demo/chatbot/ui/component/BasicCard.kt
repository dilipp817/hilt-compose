package com.demo.chatbot.ui.component

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.demo.chatbot.data.model.PhotosModel
import com.demo.chatbot.ui.containers.ChatActivity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BasicCard(photosModel: PhotosModel) {
    val context = LocalContext.current;
    Card(modifier = Modifier
        .padding(8.dp)
        .width(IntrinsicSize.Max), onClick = {
        context.startActivity(Intent(context, ChatActivity::class.java))
    }) {
        Row {
            Image(
                painter = rememberImagePainter(photosModel.url, builder = {
                    transformations(CircleCropTransformation())
                }),
                contentDescription = photosModel.title,
                modifier = Modifier
                    .size(70.dp)
                    .padding(8.dp)
            )
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f), text = photosModel.title
            )
        }
    }
}