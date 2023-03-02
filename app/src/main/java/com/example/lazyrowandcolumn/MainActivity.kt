package com.example.lazyrowandcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazyrowandcolumn.ui.theme.LazyRowAndColumnTheme

class MainActivity : ComponentActivity() {

    //create array of size 100 element
    private val numbers: Array<Int> = Array(100) {it + 1}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowAndColumnTheme {
                // A surface container using the 'background' color from the theme
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {

                    //Place the row and column to take 50% height of screen
                    Column(Modifier.fillMaxHeight(.5f)) {
                        Text(
                            text = "Row",
                            color = Color.Black,
                            modifier = Modifier.padding(start = 8.dp)
                        )

                        LazyRowExample(numbers)

                        Text(
                            text = "Column",
                            color = Color.Black,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        //lazycolumn implementation
                        LazyColumnExample(numbers)
                    }

                    Column(Modifier.fillMaxHeight()) {

                        Text(
                            text = getString(R.string.Grid),
                            color = Color.Black,
                            modifier = Modifier.padding(start = 8.dp)
                        )

                        GridExample(numbers)

                    }

                }
            }
        }
    }
}

@Composable
fun LazyRowExample(numbers:Array<Int>) {

    LazyRow(contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item{
            RowItem(number = 0)
        }

        items(10){ currentCount ->
            RowItem(number = currentCount)
        }
        items(numbers) { arrayItem ->
            RowItem(number = arrayItem)
        }
    }

}

@Composable
fun RowItem(number: Int) {
    Row(modifier = Modifier
        .size(100.dp)
        .background(Color.Yellow)
        .border(2.dp, Color.Green),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        Text(
            text = "This is Item Number $number", color = Color.Black
        )

    }
}

@Composable
fun LazyColumnExample(numbers: Array<Int>) {
    LazyColumn(contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(numbers) { arrayItem->
            ColumnItem(number = arrayItem)

        }
    }
}

@Composable
fun ColumnItem(number: Int) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color.Cyan)
        .border(4.dp, Color.Black),
         verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "This is Item Number $number", color = Color.Gray
        )

    }
}

@Composable
fun GridExample(numbers: Array<Int>) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(numbers) {
            RowItem(number = it)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyRowAndColumnTheme {
       // Greeting("Android")
    }
}