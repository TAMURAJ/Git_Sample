package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Sample9 {
	static int a=0;
	static int b=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		String [] kanjiString = {"括弧","検索","移行","構築","順次","端末","抽出","弊社","容易","略語",
											"任意","迅速","妥当性","付録","別途","保守","連携","応答","稼働","概要",
											"既存","欠陥","考慮","承認","遷移","律儀","流布","暴露","納屋","精進",
											"体裁","相殺","本望","便乗","権化","会釈","建立","頒布","渋滞","折衷案",
											"綿密","厳格","類似","完遂","丁寧","雰囲気","斡旋","円滑","逐次","添削"};
		String [] hiraganaString = {"かっこ","けんさく","いこう","こうちく","じゅんじ","たんまつ","ちゅうしゅつ","へいしゃ","ようい","りゃくご",
												"にんい","じんそく","だとうせい","ふろく","べっと","ほしゅ","れんけい","おうとう","かどう","がいよう",
												"きぞん","けっかん","こうりょ","しょうにん","せんい","りちぎ","るふ","ばくろ","なや","しょうじん",
												"ていさい","そうさい","ほんもう","びんじょう","ごんげ","えしゃく","こんりゅう","はんぷ","じゅうたい","せっちゅうあん",
												"めんみつ","げんかく","るいじ","かんすい","ていねい","ふんいき","あっせん","えんかつ","ちくじ","てんさく"};
		String [] meanString = {"()のこと","調べること","ある状態から他の状態へ移っていくこと","組み立てて築くこと","順序に従って物事をするさま","はし。端末装置の略","全体の中から、ある物を抜き出すこと","自分の会社をへりくだっていう語","たやすいこと。やさしいこと","語形の一部分を省略して簡略した語。",
											"その人の自由意志にまかせること","物事の進み具合や行動などが非常に速いこと","うまく適合する度合い","主要な物に添えられたもの","別の方法","正常な状態を保つこと","互いに連絡をとり協力して物事を行うこと。","問いかけや呼びかけに答えること。受け答え。","稼ぎ働くこと。機械を動かすこと","全体の要点をまとめたもの",
											"以前から存在すること","欠けて足りないこと","物事を、いろいろな要素を含めてよく考えること","そのことが正当または事実であると認めること","うつりかわること","ひどく義理がたいこと。実直なこと。","世に広まること。広く世間に行き渡ること。","他人の秘密・悪事などをあばいて明るみに出すこと。","別棟に設けた物置用の小屋。","そのことだけに心を集中して努力すること。",
											" 世間の人の目にうつる自分のかっこう。世間体","貸し借り・損得などを互いに消し合ってゼロにすること\n相反するものが互いに影響し合って、その効果などが差し引きされること。","本来の望み。もとから抱いている志。","巧みに機会をとらえて利用すること"," ある抽象的な特質が、具体的な姿をとって現れたかのように思える人やもの","軽くあいさつや礼を交わすこと。","寺院や堂・塔などを建てること\n築き上げること","品物や資料などを、広く配ること。","物事がとどこおってすらすらと進まないこと。","二つ以上の案のよいところをとり合わせて、一つにまとめた案。",
											"詳しく細かいこと","規律や道徳にきびしく、不正や怠慢を許さないこと","互いに共通点があること。似かようこと",")最後までやりとおすこと。完全に成し遂げること","礼儀正しいこと。丁重で親切なこと","その場にかもし出されている気分","間に入って双方をうまく取り持つこと","物事が滞らず、すらすら運ぶこと","順を追って次々に物事がなされるさま","文章・答案などを、書き加えたり削ったりして、改め直すこと"};
		Map<String,String> wrong =new HashMap<String,String>();
		System.out.println("漢字の読みをひらがなで入力してください");


		String retry;
		String giveUp;
		String wrongAnswer;
		boolean loop = true;
		int last=-1;
		do {
			int hiragana;
			do {
				hiragana = rand.nextInt(kanjiString.length);
			}while(hiragana==last);
			last=hiragana;

			while(loop) {
				System.out.print(kanjiString[hiragana]+"：");
				String str = sc.next();

				if(str.equals(hiraganaString[hiragana])) {
					a++;
					System.out.print("正解です。意味は： " +meanString[hiragana]+"\nあ…次へ進む/い…終了 :");
					break;
				}
				else{b++;
				System.out.println("違います");
				wrong.put(kanjiString[hiragana],hiraganaString[hiragana]);
				System.out.print("あきらめて正解を見ますか？ Yes _う / No _え :");
				giveUp=sc.next();

				if(giveUp.equals("う")) {
					System.out.println("答えは: " +hiraganaString[hiragana]+" /意味は： " +meanString[hiragana]);
					System.out.print("あ…次へ進む/い…終了 :");
					break;
				}
				}
			}//while(true) end

			retry=sc.next();
		}while(retry.equals("あ"));
		System.out.println();
		System.out.println("正解数："+a+"間違い数:"+b);
		System.out.println();
		System.out.print("間違えた問題を見たければ「お」を押してください :");
		wrongAnswer=sc.next();
		if(wrongAnswer.equals("お")) {
			Iterator it = wrong.keySet().iterator();
			while(it.hasNext()) {
				Object o = it.next();
				System.out.println(o+"/"+wrong.get(o));
			}
		}
	sc.close();
	}

}
