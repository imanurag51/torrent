package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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

class loginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val controller = findNavController()

        return ComposeView(requireContext()).apply {
            setContent {
                LoginPage(controller)
            }
        }
    }
}
@Composable
fun LoginPage(controller: NavController){
    Scaffold(backgroundColor = Color.Black) {
        Column() {
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Surface(color = Color.Transparent,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                ) {
                Text(text = "Login Page",style = TextStyle(
                    color = Color.White,fontSize = 25.sp,fontWeight = FontWeight.Bold),
                    modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth(0.8f).height(50.dp)
                    .border(2.dp,color = Color.Blue,shape = CircleShape)
            ) {
                Text(text = "User Name",style = TextStyle(
                        color = Color.LightGray,fontSize = 15.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth(0.8f).height(50.dp)
                    .border(2.dp,color = Color.Blue,shape = CircleShape)
                    .gravity(align = Alignment.End),
            ) {
                Text(text = "Password",style = TextStyle(
                        color = Color.LightGray,fontSize = 15.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Surface(color = Color.Transparent,modifier = Modifier.fillMaxWidth(0.8f).height(50.dp)
                    .border(2.dp,color = Color.Blue,shape = CircleShape)
            ) {
                Text(text = "Passcode",style = TextStyle(
                        color = Color.LightGray,fontSize = 15.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Surface(color = Color.Transparent,modifier = Modifier.height(50.dp).width(100.dp)
                            .border(2.dp, color = Color.Green, shape = CircleShape)
                            .gravity(align = Alignment.CenterHorizontally)
                            .clickable(onClick = {
                                controller.navigate(R.id.action_loginFragment_to_movieMainFragment)
                            }),
            ) {
                Text(text = "Login",style = TextStyle(
                        color = Color.Green,fontSize = 20.sp,fontWeight = FontWeight.Bold),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center))
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.08f))
            Text(text = "Forgot User Name/Password",style = TextStyle(color = Color.Gray),
                    modifier = Modifier.gravity(align = Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Row(modifier = Modifier.gravity(align = Alignment.CenterHorizontally)) {
                Card(backgroundColor = Color.Blue,modifier = Modifier.height(50.dp).width(50.dp)
                        .border(2.dp,color = Color.Cyan,shape = CircleShape),
                        shape = CircleShape
                ) {
                    Text(text = "Google",style = TextStyle(
                            color = Color.White,fontSize = 10.sp,fontWeight = FontWeight.Bold),
                            modifier = Modifier.wrapContentSize(align = Alignment.Center))
                }
                Spacer(modifier = Modifier.width(50.dp))
                Card(backgroundColor = Color.Blue,modifier = Modifier.height(50.dp).width(50.dp)
                        .border(2.dp,color = Color.Cyan,shape = CircleShape),
                        shape = CircleShape
                ) {
                    Text(text = "Facebook",style = TextStyle(
                            color = Color.White,fontSize = 10.sp,fontWeight = FontWeight.Bold),
                            modifier = Modifier.wrapContentSize(align = Alignment.Center))
                }
                Spacer(modifier = Modifier.width(50.dp))
                Card(backgroundColor = Color.Blue, modifier = Modifier.height(50.dp).width(50.dp)
                        .border(2.dp, color = Color.Cyan,shape = CircleShape),shape = CircleShape
                ) {
                    Text(text = "Other",style = TextStyle(
                            color = Color.White,fontSize = 10.sp,fontWeight = FontWeight.Bold),
                            modifier = Modifier.wrapContentSize(align = Alignment.Center))
                }
            }
            }
        }
}