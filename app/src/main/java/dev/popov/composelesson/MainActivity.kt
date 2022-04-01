package dev.popov.composelesson

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.popov.composelesson.ui.theme.ItemBackColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
            ){
                itemsIndexed(
                    listMaker()
                ){
                        _, item ->
                    ItemColumn(item = item)
                }
            }
        }
    }
}
@Composable
fun ItemColumn(item: ItemColumnModel){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = ItemBackColor
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = item.imgID),
                contentDescription = "Image ${item.title}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(3.dp)
                    .size(100.dp)
                    .clip(shape = CircleShape)
            )
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(start = 20.dp),
                fontSize = 24.sp,
            )

        }

    }
}
fun listMaker(): List<ItemColumnModel> {
    val item: MutableList<ItemColumnModel> = mutableListOf()
    for (i in 0..9){
        item.add(ItemColumnModel(ItemMap.id[i], ItemMap.title[i]))
    }

//    val itemList = listOf(
//        ItemColumnModel(ItemMap.id[0], ItemMap.title[0]),
//        ItemColumnModel(ItemMap.id[1], ItemMap.title[1]),
//        ItemColumnModel(ItemMap.id[2], ItemMap.title[2]),
//        ItemColumnModel(ItemMap.id[3], ItemMap.title[3]),
//        ItemColumnModel(ItemMap.id[4], ItemMap.title[4]),
//        ItemColumnModel(ItemMap.id[5], ItemMap.title[5]),
//        ItemColumnModel(ItemMap.id[6], ItemMap.title[6]),
//        ItemColumnModel(ItemMap.id[7], ItemMap.title[7]),
//        ItemColumnModel(ItemMap.id[8], ItemMap.title[8]),
//        ItemColumnModel(ItemMap.id[9], ItemMap.title[9])
//    )
    Log.d("MAY", "List: $item")
    return item
}
