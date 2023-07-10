package net.kwmt27.jetpackcomposeplayground.slide

import androidx.compose.runtime.Composable
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample1_2
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample1_3
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample2_1
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample2_2
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample2_3
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample3_1
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.AnimationExample3_2
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.DetailsAndPoints3_1
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.DetailsAndPoints3_2
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.Intro
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.Intro2
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.Intro3
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.SlideTitle
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.Summary
import net.kwmt27.jetpackcomposeplayground.slide.contents.potatotips82.ThankYou

data class Slide(
    val content: @Composable () -> Unit,
)

internal val slides = listOf(
    Slide { SlideTitle() },
    Slide { Intro() },
    Slide { Intro2() },
    Slide { Intro3() },
    Slide { AnimationExample() },
    Slide { AnimationExample1_2() },
    Slide { AnimationExample1_3() },
    Slide { AnimationExample2_1() },
    Slide { AnimationExample2_2() },
    Slide { AnimationExample2_3() },
    Slide { AnimationExample3_1() },
    Slide { AnimationExample3_2() },
    Slide { DetailsAndPoints3_1() },
    Slide { DetailsAndPoints3_2() },
    Slide { Summary() },
    Slide { ThankYou() },
)
