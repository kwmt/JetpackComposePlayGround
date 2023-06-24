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

internal data class Slide(
    val title: String? = null,
    val content: @Composable () -> Unit,
)

internal val slides = listOf(
    Slide { SlideTitle() },
    Slide("自己紹介") { Intro() },
    Slide("どんなアニメーションか？") { Intro2() },
    Slide("どんなアニメーションか？（アニメーション部分のみ・簡略化）") { Intro3() },
    Slide("例1: テキストが下から上に回転するようなアニメーション") { AnimationExample() },
    Slide("例1: テキストが下から上に回転するようなアニメーション") { AnimationExample1_2() },
    Slide("例1: テキストが下から上に回転するようなアニメーション") { AnimationExample1_3() },
    Slide("例2: 緑のボックスが左から右にかけて消えていくアニメーション") { AnimationExample2_1() },
    Slide("例2: 緑のボックスが左から右にかけて消えていくアニメーション") { AnimationExample2_2() },
    Slide("例2: 緑のボックスが左から右にかけて消えていくアニメーション") { AnimationExample2_3() },
    Slide("例3: 右の円が青から赤にクロスフェードするアニメーション") { AnimationExample3_1() },
    Slide("例3: 右の円が青から赤にクロスフェードするアニメーション") { AnimationExample3_2() },
    Slide("他のアニメーションAPIは？") { DetailsAndPoints3_1() },
    Slide("アニメーションのパフォーマンスについて") { DetailsAndPoints3_2() },
    Slide("まとめ") { Summary() },
    Slide { ThankYou() },
)
