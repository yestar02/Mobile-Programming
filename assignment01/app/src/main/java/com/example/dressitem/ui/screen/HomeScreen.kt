package com.example.dressitem.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dressitem.ui.components.DrawItems
import com.example.dressitem.viewmodel.DressItemViewModel


@Composable
fun HomeScreen(
    vm: DressItemViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val orientation = LocalConfiguration.current.orientation
    val itemWithoutBody = vm.itemList.filter { it.name != "body" } // 선택지용 몸통 없는 리스트

    Column( // 화면 방향에 상관없이 학번이름은 상단에 보이게
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text(
            text = "202213359 우예성",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        if (orientation == Configuration.ORIENTATION_PORTRAIT) { // 세로니까 그림이랑 선택창 상하로 배치

            DrawItems(
                vm.itemList, // 그림은 몸통도 그려야하니까 전체로 넘기기
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(itemWithoutBody) { item -> // 선택창에 몸통은 없어야하니까 필터된 리스트 갖고오기
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { vm.selectedItem(item) }
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = item.isSelected,
                            onCheckedChange = { vm.selectedItem(item) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item.name,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }


        } else { // 가로모드니까 row로 2개 배열하기
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                DrawItems(
                    itemList = vm.itemList,
                    modifier = Modifier
                        .width(300.dp)
                        .fillMaxHeight()
                )

                Spacer(modifier = Modifier.width(20.dp))

                LazyVerticalGrid( // 선택창은 세로모드일때와 동일
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(itemWithoutBody) { item -> // 선택창에 몸통은 없어야하니까 필터된 리스트 갖고오기
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { vm.selectedItem(item) }
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = item.isSelected,
                                onCheckedChange = { vm.selectedItem(item) }
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item.name,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }
                }
            }





        }
    }


}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}