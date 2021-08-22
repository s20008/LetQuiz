package jp.ac.it_college.s20008.android.letquiz

import kotlin.collections.ArrayList

/**
 * @author: ffzs
 * @Date: 2020/9/10 上午10:31
 */

object Constants {

    const val QUESTION_COUNT = "question_count"
    const val CORRECT_COUNT = "correct_count"
    const val WRONG_COUNT = "wrong_count"


    fun getQuestions(count: Int): MutableList<Question> {
        val questions = ArrayList<Question>()
        val que1 = Question(
            1, "源氏物語の作者は誰ですか？",
            1,"不明", "紫式部", "兼好法師", "夏目漱石", 2
        )
        val que2 = Question(
            2, "745年の8月19日は、絶世の美女であった楊貴妃が唐・玄宗皇帝の妃となった「楊貴妃の日」です。さて、楊貴妃という通称ですが、、、どこで切る？",
            2, "楊・貴妃", "楊貴・妃", "楊・貴・妃", "分からない", 1
        )
        val que3 = Question(
            3, "仲睦まじかった楊貴妃と玄宗皇帝。詩人・白居易(白楽天)が、その二人の姿を元に詩作し「長恨歌」として今に伝えられています。さて「長恨歌」では仲のよい2人を伝説上の生物「比翼の鳥」とたとえていますが、この鳥はどんな鳥？",
            3,
            "情翼が二枚ある鳥", "翼が片方しかない鳥", "片方の翼だけが大きい鳥", "翼がない鳥", 2
        )
        val que4 = Question(
            4, "「論語」といえば、中国の思想家である誰の言葉をまとめたもの？",
            4, "孔子", "孟子", "老子", "庄子", 1
        )
        val que5 = Question(
            5, "ディズニーアニメに登場するダンボはどんな動物？",
            5, "ロバ", "クマ", "ウシ", "ゾウ", 4
        )
        val que6 = Question(
            6, "山形県東部に位置し、将棋の駒の生産量が全国の9割を占めることで知られる都市はどこ？",
            6, "酒田市", "米沢市", "天童市", "鶴岡市", 3
        )
        val que7 = Question(
            7, "元素記号で塩素を表すアルファベット2文字は何？",
            7, "Ag", "Cl", "Cu", "Ca", 2
        )
        val que8 = Question(
            8, "一般的な「かにかま」の原材料は何？",
            8, "ホタテ", "マグロ", "カニ", "スケトウダラ", 4
        )
        val que9 = Question(
            9, "アニメ「美少女戦士セーラームーン」のヒロインは月野〇〇〇。〇〇〇は何？",
            9, "さくら", "もみじ", "うさぎ", "ひつじ", 3
        )
        val que10 = Question(
            10, "理想も（）もない",
            10, "糸瓜", "胡瓜", "西瓜", "冬瓜", 1
        )
        val que11 = Question(
            11, "血糖値を減少させる効果がある、すい臓のランゲルハンス島β細胞から分泌されるホルモンは？",
            11, "グルカゴン", "バソプレシン", "ソマトスタチン", "インシュリン", 4
        )
        val que12 = Question(
            12, "足利義政が造営した東山山荘が前身。上段に枯山水、下段に池泉回遊式の素朴な風情の庭園を持つ寺院は？",
            12, "銀閣寺", "竜安寺", "清水寺", "滝口寺", 1
        )
        val que13 = Question(
            13, "無愛想で人に取り合わないことわざ「木で◯をくくる」。◯の中は何？",
            13, "耳", "鼻", "口", "手", 2
        )
        val que14 = Question(
            14, "チェスにおいて、次に動かせる駒が無く、ゲームが継続できずに「引き分け」になることを何という？",
            14, "プロモーション", "チェックメイト", "ステイルメイト", "キャスリング", 3
        )
        val que15 = Question(
            15, "中国語で「シェイシェイ」、フランス語で「メルシイ」とはどういう意味？",
            15, "さようなら", "すみません", "こんにちは", "ありがとう", 4
        )

        questions.addAll(
            listOf(que1, que2, que3, que4, que5, que6, que7, que8, que9, que10, que11, que12, que13, que14, que15)
        )

        questions.shuffle()
        return questions.subList(0, count)
    }
}