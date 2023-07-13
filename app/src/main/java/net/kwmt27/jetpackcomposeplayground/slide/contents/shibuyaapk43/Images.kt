package net.kwmt27.jetpackcomposeplayground.slide.contents.shibuyaapk43

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.kwmt27.jetpackcomposeplayground.slide.components.SlideImage

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun SlideImages() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        FlowRow {
            images.forEach {
                SlideImage(it)
            }
        }
    }
}

private val images =
    listOf(
        "https://images.pexels.com/photos/1170986/pexels-photo-1170986.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1643457/pexels-photo-1643457.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1828875/pexels-photo-1828875.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/3777622/pexels-photo-3777622.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/977935/pexels-photo-977935.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/982300/pexels-photo-982300.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1741206/pexels-photo-1741206.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2173872/pexels-photo-2173872.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1317844/pexels-photo-1317844.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/755834/pexels-photo-755834.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/384555/pexels-photo-384555.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2686914/pexels-photo-2686914.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2928158/pexels-photo-2928158.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/3257811/pexels-photo-3257811.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/3318215/pexels-photo-3318215.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/3525298/pexels-photo-3525298.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/3643714/pexels-photo-3643714.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/3712095/pexels-photo-3712095.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2499282/pexels-photo-2499282.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2361952/pexels-photo-2361952.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2698519/pexels-photo-2698519.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2113332/pexels-photo-2113332.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/866496/pexels-photo-866496.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1754986/pexels-photo-1754986.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1835008/pexels-photo-1835008.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/8985189/pexels-photo-8985189.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/6853287/pexels-photo-6853287.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/7410722/pexels-photo-7410722.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/6897077/pexels-photo-6897077.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/6869655/pexels-photo-6869655.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/15379284/pexels-photo-15379284.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/7149465/pexels-photo-7149465.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/15435631/pexels-photo-15435631.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/15445009/pexels-photo-15445009.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/14721098/pexels-photo-14721098.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/13722001/pexels-photo-13722001.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/617278/pexels-photo-617278.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/416160/pexels-photo-416160.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1741205/pexels-photo-1741205.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/57416/cat-sweet-kitty-animals-57416.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2071873/pexels-photo-2071873.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1056251/pexels-photo-1056251.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/208984/pexels-photo-208984.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/209037/pexels-photo-209037.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/774731/pexels-photo-774731.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1543793/pexels-photo-1543793.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/69932/tabby-cat-close-up-portrait-69932.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2194261/pexels-photo-2194261.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/127028/pexels-photo-127028.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1314550/pexels-photo-1314550.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/669015/pexels-photo-669015.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2558605/pexels-photo-2558605.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/96938/pexels-photo-96938.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/126407/pexels-photo-126407.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/923360/pexels-photo-923360.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2071882/pexels-photo-2071882.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1276553/pexels-photo-1276553.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1472999/pexels-photo-1472999.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/2061057/pexels-photo-2061057.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/35888/amazing-beautiful-breathtaking-clouds.jpg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/257532/pexels-photo-257532.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/68594/pexels-photo-68594.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/982865/pexels-photo-982865.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1440387/pexels-photo-1440387.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/821736/pexels-photo-821736.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1521306/pexels-photo-1521306.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/982314/pexels-photo-982314.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/991831/pexels-photo-991831.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/33537/cat-animal-cat-portrait-mackerel.jpg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/236606/pexels-photo-236606.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/615369/pexels-photo-615369.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/979247/pexels-photo-979247.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/804475/pexels-photo-804475.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1084425/pexels-photo-1084425.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1576193/pexels-photo-1576193.jpeg?auto=compress&cs=tinysrgb&h=350",
        "https://images.pexels.com/photos/1359307/pexels-photo-1359307.jpeg?auto=compress&cs=tinysrgb&h=350"
    )
