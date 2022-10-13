package com.demo.chatbot.ui.containers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import com.demo.chatbot.data.model.PhotosModel
import com.demo.chatbot.ui.component.BasicCard
import com.demo.chatbot.app.theme.ChatBotTheme
import com.demo.chatbot.viewmodel.PhotosViewModel

@AndroidEntryPoint
class EntryPointActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val photosVM: PhotosViewModel by viewModels()
        setContent {
            ChatBotTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (photosVM.snapshotStateList.isEmpty()) {
                        LoadingState()
                    } else
                        MainContent(photosVM.snapshotStateList)
                }
            }
        }
    }
}

@Composable
fun LoadingState(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
        Text(text = "Loading...", modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MainContent(photoList: SnapshotStateList<PhotosModel>) {
    Column {
        LazyColumn(
            Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        ) {
            items(
                items = photoList,
                itemContent = {
                    BasicCard(it)
                })
        }
    }
}