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


class SeriesMainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val controller = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                SeriesMain(controller)
            }
        }
    }
}


@Composable
fun SeriesMain(controller: NavController){
    val scaffoldState = rememberScaffoldState()
    Scaffold(backgroundColor = Color.Black,
            topBar = {
                TopAppBar(
                        title = {
                            Text("Series", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
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
                        elevation = 20.dp
                )
            },
            drawerContent = {
                Column {
                    Card(modifier = Modifier.height(200.dp).fillMaxWidth(1f), backgroundColor = Color.Blue) {
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
                    Card(modifier = Modifier.height(50.dp).fillMaxWidth(1f)) {
                        ListItem(text = { Text(text = "Movies") },
                                modifier = Modifier.clickable(onClick = {
                                    controller.navigate(R.id.action_seriesMainFragment_to_movieMainFragment)
                                }))
                    }
                    Divider(color = Color.Blue)
                    Card(backgroundColor = Color.LightGray, modifier = Modifier.height(50.dp).fillMaxWidth(1f)) {
                        ListItem(text = { Text(text = "Series") })
                    }
                    Divider(color = Color.Blue)
                    Card(modifier = Modifier.height(50.dp).fillMaxWidth(1f)){
                        ListItem(text = { Text(text = "Privet File") },
                                modifier = Modifier.clickable(onClick = {
                                    controller.navigate(R.id.action_seriesMainFragment_to_privetFragment)
                                }))
                    }
                    Divider(color = Color.Blue)
                }
            },
            scaffoldState = scaffoldState
    ) {
        ScrollableColumn() {
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(2.dp).border(2.dp,color = Color.Blue,shape = CircleShape),

                ) {
                Text(text = "Series",style = TextStyle(
                    color = Color.White,fontSize = 20.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            repeat(times = 20){
                ScrollableRow() {
                    repeat(times = 2){
                        Card(
                            modifier = Modifier.height(200.dp).width(200.dp)
                                .clickable(onClick = {
                                    controller.navigate(R.id.action_seriesMainFragment_to_seriesDetailsFragment)
                                }).padding(2.dp)
                        ) {
                            Stack() {
//                                TODO series image
//                                Image
                                Column(modifier = Modifier.gravity(align = Alignment.BottomStart)) {
                                    ScrollableRow() {
                                        Text(text = "Series Name",modifier = Modifier.padding(start = 5.dp),
                                        style = TextStyle(fontWeight = FontWeight.Bold,fontSize = 20.sp))
                                    }
                                    Text(text = "Year",modifier = Modifier.padding(start = 5.dp))
                                    Text(text = "Seasons",modifier = Modifier.padding(start = 5.dp))
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}