package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
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

class southFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val controller = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                SouthMovies(controller)
            }
        }
    }
}
@Composable
fun SouthMovies(controller: NavController){
    Scaffold(backgroundColor = Color.Black,
    ) {
        ScrollableColumn() {
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Surface(color = Color.Transparent,
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(2.dp).border(2.dp,color = Color.Blue,
                                    shape = CircleShape),

                ) {
                Text(text = "South Movies",
                        style = TextStyle(color = Color.White,
                                fontSize = 20.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            repeat(times = 20){
                ScrollableRow() {
                    repeat(times = 2){
                        Card(
                            modifier = Modifier.height(200.dp).width(200.dp)
                                .clickable(onClick = {
                                    controller.navigate(R.id.action_southFragment_to_movieDetailFragment)
                                }).padding(2.dp)
                        ) {
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
}