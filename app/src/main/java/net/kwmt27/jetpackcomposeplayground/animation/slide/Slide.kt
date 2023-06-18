package net.kwmt27.jetpackcomposeplayground.animation.slide

internal data class Slide(val title: String, val content: String)

internal val slides = listOf(
    Slide("イントロダクション", "自己紹介"),
    Slide("具体的なアニメーションの実装例", "テキストのアニメーションの説明"),
    Slide("実装の詳細とポイントの解説", "他のアニメーションAPIの比較とパフォーマンスについて"),
    Slide("成果と学び", "アニメーションの成果と今後の展望"),
    Slide("まとめと質疑応答", "プレゼンのまとめと質問への対応")
)
