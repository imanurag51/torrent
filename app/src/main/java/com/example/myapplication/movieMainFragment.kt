package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class movieMainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val controller = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                MovieMain(controller)
            }
        }
    }
}
@Composable
fun MovieMain(controller: NavController){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
            backgroundColor = Color.Black,
            topBar = {
                TopAppBar(
                        title = {
                            Text("Movies", style = TextStyle(fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold))
                        },
                        navigationIcon = {
                            //IconButton so that presses can be registered
                            IconButton(onClick = {
                                //open the drawer
                                scaffoldState.drawerState.open()
                            }) {
                                Icon(Icons.Filled.Menu)
                            }
                        },
                        backgroundColor = MaterialTheme.colors.surface,
                        elevation = 20.dp,
                )
            },
            drawerContent = {
                Column {
                    Card(modifier = Modifier.height(200.dp).fillMaxWidth(1f),
                            backgroundColor = Color.Blue) {
                        Stack() {
//                            Image(asset = imageResource(id = R.drawable.img),contentScale = ContentScale.Fit,)
                            Column() {
                                Text(text = "Welcome to the User",
                                        modifier = Modifier.wrapContentSize(align = Alignment.BottomStart),
                                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                            }
                        }
                    }
                    Divider(color = Color.Blue)
                    Card(modifier = Modifier.height(50.dp).fillMaxWidth(1f),
                            backgroundColor = Color.LightGray) {
                        ListItem(text = { Text(text = "Movies") })
                    }
                    Divider(color = Color.Blue)
                    Card(modifier = Modifier.height(50.dp).fillMaxWidth(1f)) {
                        ListItem(text = { Text(text = "Series") },
                                modifier = Modifier.clickable(onClick = {
                                    controller.navigate(R.id.action_movieMainFragment_to_seriesMainFragment)
                                }))
                    }
                    Divider(color = Color.Blue)
                    Card(modifier = Modifier.height(50.dp).fillMaxWidth(1f)) {
                        ListItem(text = { Text(text = "Privet File") },
                                modifier = Modifier.clickable(onClick = {
                                    controller.navigate(R.id.action_movieMainFragment_to_privetFragment)
                                }))
                    }
                    Divider(color = Color.Blue)
                    Spacer(modifier = Modifier.fillMaxHeight(0.8f))
                    Divider(color = Color.Blue)
                    Card(modifier = Modifier.height(50.dp).fillMaxWidth(1f)) {
                        ListItem(text = { Text(text = "Exit") },
                                modifier = Modifier.clickable(onClick = {}))
                    }
                    Divider(color = Color.Blue)
                }
            },
            scaffoldState = scaffoldState
    ) {
        ScrollableColumn {
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(2.dp).clickable(onClick ={
                    controller.navigate(R.id.action_movieMainFragment_to_hollywoodFragment)
                })
                .border(2.dp,color = Color.Blue,shape = CircleShape),

                ) {
                Text(text = "Hollywood Movies",style = TextStyle(
                    color = Color.White,fontSize = 20.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            ScrollableRow() {
                repeat(times = 20){
                    Card(modifier = Modifier.height(200.dp).width(200.dp).padding(2.dp)
                            .clickable(onClick = {
                                controller.navigate(R.id.action_movieMainFragment_to_movieDetailFragment)
                            })){
                        Stack() {
//                            TODO image ko surface ki size me fill karna
//                            Image(asset = imageResource(id = R.drawable.img))
                            Column(modifier = Modifier.gravity(align = Alignment.BottomStart)) {
                                ScrollableRow() {
                                    Text(text = "Movie Name",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red,
                                            fontWeight = FontWeight.Bold,fontSize = 20.sp))
                                }
                                Text(text = "Language",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red))
                                Text(text = "120 min",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red))
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(2.dp).clickable(onClick ={
                    controller.navigate(R.id.action_movieMainFragment_to_bollywoodFragment)
                }).border(2.dp,
                    color = Color.Blue,shape = CircleShape),
            ) {
                Text(text = "Bollywood Movies",style = TextStyle(
                    color = Color.White,fontSize = 20.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            ScrollableRow() {
                repeat(times = 20){
                    Card(modifier = Modifier.height(200.dp).width(200.dp).padding(2.dp)
                            .clickable(onClick = {
                                controller.navigate(R.id.action_movieMainFragment_to_movieDetailFragment)
                            })){
                        Stack() {
//                            TODO image problem
//                            Image(asset = imageResource(id = R.drawable.img))
                            Column(modifier = Modifier.gravity(align = Alignment.BottomStart)) {
                                ScrollableRow() {
                                    Text(text = "Movie Name",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red,
                                            fontWeight = FontWeight.Bold,fontSize = 20.sp))
                                }
                                Text(text = "Language",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red))
                                Text(text = "120 min",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red))
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(2.dp).clickable(onClick ={
                    controller.navigate(R.id.action_movieMainFragment_to_southFragment)
                }).border(2.dp,
                    color = Color.Blue,shape = CircleShape),
            ) {
                Text(text = "South Movies",style = TextStyle(
                    color = Color.White,fontSize = 20.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            ScrollableRow() {
                repeat(times = 20){
                    Card(modifier = Modifier.height(200.dp).width(200.dp).padding(2.dp)
                            .clickable(onClick = {
                                controller.navigate(R.id.action_movieMainFragment_to_movieDetailFragment)
                            })){
                        Stack() {
//                            TODO image problem
//                            Image(asset = imageResource(id = R.drawable.img))
                            Column(modifier = Modifier.gravity(align = Alignment.BottomStart)) {
                                ScrollableRow() {
                                    Text(text = "Movie Name",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red,
                                            fontWeight = FontWeight.Bold,fontSize = 20.sp))
                                }
                                Text(text = "Language",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red))
                                Text(text = "120 min",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(color = Color.Red))
                            }
                        }
                    }
                }
            }
        }
    }
}