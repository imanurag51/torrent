package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.ui.tooling.preview.Preview

class playerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                Player()
            }
        }
    }
}
@Preview
@Composable
fun Player(){
    Scaffold(backgroundColor = Color.Green) {
        Text("Player")
    }
}