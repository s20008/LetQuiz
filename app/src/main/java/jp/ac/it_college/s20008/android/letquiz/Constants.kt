package jp.ac.it_college.s20008.android.letquiz

import kotlin.collections.ArrayList


object Constants {

    const val QUESTION_COUNT = "question_count"
    const val CORRECT_COUNT = "correct_count"
    const val WRONG_COUNT = "wrong_count"
    const val TIMER_COUNT = "timer_count"


    fun getQuestions(count: Int): MutableList<Question> {
        val questions = ArrayList<Question>()
        val que1 = Question(
            1, "中国語で「シェイシェイ」、フランス語で「メルシイ」とはどういう意味？",
            R.drawable.s20008_language, "さようなら", "すみません", "こんにちは", "ありがとう", 4
        )
        val que2 = Question(
            2, "足利義政が造営した東山山荘が前身。上段に枯山水、下段に池泉回遊式の素朴な風情の庭園を持つ寺院は？",
            R.drawable.s20008_temple, "銀閣寺", "竜安寺", "清水寺", "滝口寺", 1
        )
        val que3 = Question(
            3, "仲睦まじかった楊貴妃と玄宗皇帝。詩人・白居易(白楽天)が、その二人の姿を元に詩作し「長恨歌」として今に伝えられています。さて「長恨歌」では仲のよい2人を伝説上の生物「比翼の鳥」とたとえていますが、この鳥はどんな鳥？",
            R.drawable.s20008_bird,
            "情翼が二枚ある鳥", "翼が片方しかない鳥", "片方の翼だけが大きい鳥", "翼がない鳥", 2
        )
        val que4 = Question(
            4, "「論語」といえば、中国の思想家である誰の言葉をまとめたもの？",
            R.drawable.s20008_kongzi, "孔子", "孟子", "老子", "庄子", 1
        )
        val que5 = Question(
            5, "ディズニーアニメに登場するダンボはどんな動物？",
            R.drawable.s20008_disney, "ロバ", "クマ", "ウシ", "ゾウ", 4
        )
        val que6 = Question(
            6, "山形県東部に位置し、将棋の駒の生産量が全国の9割を占めることで知られる都市はどこ？",
            R.drawable.s20008_yamagata, "酒田市", "米沢市", "天童市", "鶴岡市", 3
        )
        val que7 = Question(
            7, "元素記号で塩素を表すアルファベット2文字は何？",
            R.drawable.s20008_genso, "Ag", "Cl", "Cu", "Ca", 2
        )
        val que8 = Question(
            8, "一般的な「かにかま」の原材料は何？",
            R.drawable.s20008_kani, "ホタテ", "マグロ", "カニ", "スケトウダラ", 4
        )
        val que9 = Question(
            9, "アニメ「美少女戦士セーラームーン」のヒロインは月野〇〇〇。〇〇〇は何？",
            R.drawable.s20008_seramun, "さくら", "もみじ", "うさぎ", "ひつじ", 3
        )
        val que10 = Question(
            10, "チェスにおいて、次に動かせる駒が無く、ゲームが継続できずに「引き分け」になることを何という？",
            R.drawable.s20008_chessman, "プロモーション", "チェックメイト", "ステイルメイト", "キャスリング", 3
        )
        val que11 = Question(
            11,"公務員はどれ？",null,"お笑い芸人","消防士","YouTuber","建築士",2
        )
        val que12 = Question(
            12,"お酒を飲めるようになる歳は？",null,"２０歳","２１歳","２２歳","２３歳",1
        )
        val que13 = Question(
            13,"侍JAPANの監督は誰？",null,"稲葉監督","原監督","大桝監督","大谷監督",1
        )
        val que14 = Question(
            14,"原作のサザエさんの未来予想図では、タラちゃんに妹がいます。名前は何でしょう",null,
            "ホタテちゃん","ヒトデちゃん","アワビちゃん","アサリちゃん",2
        )
        val que15 = Question(
            15,"ある音楽が頭にこびりついて離れなく現象をなんという？",null,"イヤーワーム",
            "イヤースティック","イヤーフルート","イヤーループ",1
        )
        val que16 = Question(
            16,"三角形の内角の和は？",null,"180","360","540","どれでもない",1
        )
        val que17 = Question(
            17,"悪事を隠して知らないフリをするようすを「ねこばば」というが「ばば」とはどういう意味が",null,
            "ババ抜き","おばさん","悪魔","うんこ",4
        )
        val que18 = Question(
            18,"今通ってる学校は？",null,"ITカレッジ沖縄","ITカレッジ横浜","ITカレッジ神奈川","ITカレッジ大きな輪",
            1
        )
        val que19 = Question(
            19,"平良かいま選手の出身高校は？",null,"八重山商工","宮古高校","那覇高校","沖縄尚学",
            1
        )
        val que20 = Question(
            20,"ゲームAPEXでバンガーロールのセリフ、「私は◯◯よ」〇〇に入る言葉はどれか",null,
            "アフロ","カービン","大砲","戦車",3
        )

        questions.addAll(
            listOf(que1, que2, que3, que4, que5, que6, que7, que8, que9, que10,que11,que12,que13,que14,que15,que16,que17,que18,que19,que20)
        )

        questions.shuffle()
        return questions.subList(0, count)
    }
}