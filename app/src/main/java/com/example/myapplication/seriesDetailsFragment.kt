package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
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

class seriesDetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val controller = findNavController()
        return ComposeView(requireContext()).apply {
            setContent {
                SeriesDetails(controller)
            }
        }
    }
}
@Composable
fun SeriesDetails(controller: NavController){
    Scaffold(backgroundColor = Color.Black,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                controller.navigate(R.id.action_seriesDetailsFragment_to_playerFragment)
            }, contentColor = Color.Black) {
                Icon(asset = Icons.Filled.PlayArrow)
            }
        }
    ) {
        Column() {
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth().height(50.dp)
                .padding(2.dp).clickable(onClick ={})
                .border(2.dp,color = Color.Blue,shape = CircleShape),

                ) {
                Text(text = "Series Details",style = TextStyle(
                    color = Color.White,fontSize = 20.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
            Card(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
                shape = RoundedCornerShape(30.dp)) {
//                TODO
//                Image(asset = imageResource(id = R.drawable.img))
            }
            Text(text = "Series Name",modifier = Modifier.padding(top = 5.dp,start = 5.dp),
                style = TextStyle(color = Color.White,fontSize = 20.sp,fontWeight = FontWeight.Bold)
            )
            Text(text = "Season 1",style = TextStyle(color = Color.White),modifier = Modifier.padding(start = 5.dp))
            Text(text = "Year",style = TextStyle(color = Color.White),modifier = Modifier.padding(start = 5.dp))
            ScrollableColumn() {
                Text(text = "Summery",style = TextStyle(color = Color.White),modifier = Modifier.padding(start = 5.dp))
            }
        }
    }
}