package assignment8;
//Author: Jonathan Dang
//Project: PP10.2 and PP10.4 Assignment 8
import java.util.Random;

public class SequenceDemo {
	public static void main(String[] args)
	{
		LastDigitDistribution dist1 = new LastDigitDistribution();
		dist1.process(new SquareSequence(), 1000);
		dist1.display();
		
		System.out.println();
		LastDigitDistribution dist2 = new LastDigitDistribution();
		dist2.process(new RandomSequence(), 1000);
		dist2.display();
		
		System.out.println();
		LastDigitDistribution dist3 = new LastDigitDistribution();
		MySequence seq = new MySequence();
		Random rand = new Random();
		for(int i = 0; i < 1000;i++)
		{
			int n = rand.nextInt();
			if(n < 0)
				n = n*-1;
			seq.addToSequence(n);
		}
		
		while(!seq.hasNext())
		{
			for(int i = 0; i < 100;i++)
			{
				for(int j = 0; j < 10; j++)
					System.out.print(seq.next() + " ");
				System.out.println();
			}
		}
		seq.reset();
		dist3.process(seq, 1000);
		dist3.display();
	}
}

/*
////////////////////////////////////////////////////////////////////////////
PP10.2 Run
////////////////////////////////////////////////////////////////////////////
* -> 5 Entries
0: ********************
1: ****************************************
2: 
3: 
4: ****************************************
5: ********************
6: ****************************************
7: 
8: 
9: ****************************************

* -> 5 Entries
0: *******************
1: **********************
2: *******************
3: ***********************
4: ********************
5: *******************
6: *******************
7: *********************
8: ****************
9: *******************
////////////////////////////////////////////////////////////////////////////
PP10.4 Run
////////////////////////////////////////////////////////////////////////////
1622874777 1103288030 1976249362 2076767658 416198615 620115656 2074827634 1600691386 554245826 160333455 
1979143808 1032206836 1911001713 69323923 1602323232 827112778 1954332856 1216832938 26745962 32893971 
284877522 1040493749 643928476 1042071607 1403598179 553769893 474437217 100558678 1331504588 655961420 
140411824 2095158813 1533213976 2049329349 1645591377 1768707150 395512877 1365997265 423868241 861016324 
36157927 282875770 1440550726 1891312239 405362319 178760226 1784718322 1402831758 2103585565 258667330 
366575444 1304799336 1215643603 1693521979 1281140200 864225887 1642207427 1645277798 1029440188 679790750 
342187199 616931676 1363874949 1587616521 1477848862 680400032 1321786895 1947277201 1342788618 887836388 
1428303959 1935216448 2141861329 983853200 1507190825 556056851 210330366 994913465 1115317112 2123418007 
524857651 1126603829 515388489 1751028367 611352050 696387162 920995474 626759636 566574557 1269252313 
1057850947 154556707 1150350272 664674808 2070828998 1467451007 1458146611 154560522 1921782919 154946293 
1177836356 1290701385 1114502533 1705852142 971382700 249573291 305414239 438024201 1245979936 946680579 
1951387238 1997772512 1677507916 1477145960 556710329 444186657 1129671160 1588746299 1643594146 1678163306 
895443002 47700826 1972920813 270420816 1941615351 1521641183 1910550632 515046877 1403741453 496391589 
455411570 63350985 1614571447 199208408 2073565770 607548561 286701299 1256790660 249183527 824847053 
779374369 576815488 2004617761 1165200522 1225847978 254376531 2071342965 640194160 219862190 259218683 
16124191 1062447353 236051906 1552974225 40286764 310567389 736278832 310398475 1114341894 1037730118 
1924874341 1942958357 1363555997 1700840146 1252236769 674985367 719306239 1843207638 825625873 1250337198 
723395634 663325983 1770653891 1742842596 570709739 71587072 759074094 1033127518 84103156 1754635989 
1184338650 1242902498 1622232302 413452570 314040689 908060456 1748986887 1430497903 1431780175 544155214 
357256717 1445442223 777512179 1317623058 733604053 521661944 1504314068 1439972565 1954212686 318899065 
662499610 403574125 1535945669 1254758167 1764914604 783339352 123104621 1319252442 240524512 880852178 
1085181521 24641271 1244365498 130810888 1172702846 99596389 1712796159 482325445 1897635556 76740843 
2101543100 1892647933 1818418828 94441644 1122849904 1835317207 214401360 1577980708 1634165226 957165042 
551428508 1625909743 1202489890 731137581 1976383303 2092850194 419143334 296567556 26832351 1521290416 
528684744 54691230 916420834 1495309636 1465807033 161396848 759285128 1455635825 1376009688 2111929583 
4481762 304297275 531622225 143131884 341842637 1182583231 631059310 1726955399 1801383333 894676797 
1510385173 332075674 324046624 1606971959 494262294 761213674 166762789 1449072771 1299825251 226849264 
1890111959 24630041 1295518829 335045532 365748553 417993571 1533522437 1413297550 2056353788 340609751 
208299873 35003212 428365521 2059459398 2019214148 1220533985 1294836157 1004194547 1986578194 1453612676 
1474068610 1019335467 1713599072 1403196507 1500792083 226008957 1982525317 656280061 389675254 807101475 
479833370 399807324 314428289 1643759790 78015577 1754411982 843866868 1089940435 1796012499 2068886746 
679782379 60752081 281614305 475552854 508640866 1626110709 2069616846 209580987 789654939 2039200431 
432470440 329667704 783544254 1529601066 767468495 1419445737 1133550036 218846604 291187773 1775373757 
900515932 47683802 1383769861 890515737 2127459352 338961145 1437752620 1996898083 875436621 517298932 
1262396149 1241450420 563553483 2004657424 701104990 968057247 1024051444 2088024110 191565785 1184495953 
2034970572 419720356 816469516 1944280252 348491729 1065540135 1901086529 998442433 343865380 14316012 
1600754343 1144746878 168443736 1551049872 1214018651 592783102 1372428270 1922126917 444538844 1666926961 
1406576441 1138957394 1099326570 348291395 1714041817 164606739 1271858923 354328522 1379763641 1594903260 
165721209 118263429 1471127301 1936434017 1208808971 1099054758 147673396 31669499 85403327 139481728 
653949682 2043609657 1794737697 1182998364 1947081593 18708178 896707245 247784221 1243994375 2106621027 
161028242 40861746 1388378064 729178902 290128056 227939076 2040520753 1086272560 1982622724 1928312773 
1865637260 234356452 364488998 810002961 900452103 1865190694 595754781 1578651024 1700839518 1679900505 
583011057 1909763965 1670433422 140673269 264991267 373919621 1451627632 340352155 1923611097 1689090400 
2113242159 525550231 2557030 818252744 299423659 1286278769 2137925309 850342919 1534564080 309575134 
1378704075 979584014 1899385427 1887482928 113884356 1559773973 1893109455 165168915 2088150213 1193318191 
971834823 1863992330 714053381 801726496 254156529 2107994885 1484988459 72789600 1060769692 2014595263 
1326334195 208053261 1764093579 2121097746 874848232 1995634982 1660138463 980426618 1863372609 226495604 
1667577235 825261098 22777914 1763593114 1567024659 330653351 1310142463 1932431329 2040296060 1972116369 
1758822407 1746142271 88807960 1937136128 1785119414 1926931759 900860947 436272289 528423761 329049943 
468452718 1793913981 731368386 14123267 840204546 114697727 30823583 1935671314 1605777419 1635581109 
141031181 1676115123 933558448 1837384784 676646143 142811960 2051850820 1024391631 1729397165 1827220276 
460678178 790800647 136317752 1268580936 130990393 1851956771 1204302019 977455991 484605461 1626851989 
11459687 587777616 2098274853 1485993678 932156915 1290794328 978636145 1446637160 295217943 1886586346 
1566176800 1122659590 2029084953 1392039075 1741601856 1838240227 1076297176 25467710 2140777567 1970849463 
816183689 1297156483 1280732590 345120290 475747976 1448087025 1960668111 1285865820 1627781584 613257468 
589352049 26746734 1751392246 1228580812 1715689985 1166643064 1810927714 104572134 548591143 879722171 
1792403284 207678351 1075563545 1015802977 1722299496 1740158086 411274843 650849064 237332342 3969030 
1634174427 286642208 114980711 1870231518 1073534670 1452209028 134281133 934995997 761788232 1502279534 
1360231336 456458618 1210160030 1320374213 964066222 279509674 808967291 1515451034 347491268 266141572 
1416698564 431433071 1047981150 1810972452 1807342291 1638610515 794786327 1526232702 1376185448 1746830665 
1713986923 811723239 1837741007 2119211436 501436854 1743899211 1074543030 1771750219 1252016031 669091014 
572792567 1884834989 351303171 1827740478 116335767 1625760718 1299847670 1636958044 1476982027 1316287765 
899443793 1981595381 843483998 2069626243 1769278079 887477119 2067769452 791549998 1566451040 1534364480 
969489903 1352329432 1003658732 1824431417 1030363352 1511726789 1569495489 658842848 377985471 167703731 
1242972582 643683006 178772917 553253526 239359495 311468620 2042035254 467898036 104770989 797922320 
2081158360 1516297059 1864560063 1549766319 508333804 1637650216 497068546 281213766 521159111 1518092872 
2076367494 261770087 1409702745 1882324206 1482226638 1638246996 183951032 1868059458 908596936 1390539576 
1990629852 946805990 545405777 1692753407 806197755 872017100 876278530 373228247 90949818 82057300 
24836047 833537520 1088970166 333866517 1809917492 1358914608 1997313946 564257561 1416845534 684491486 
1311006270 600287672 1651153508 719087967 359066163 1317104910 1520092127 577314192 1534703354 1613412155 
350533349 586409324 573563791 463657750 1362379521 441133147 1808309696 1308415121 1251727386 671113225 
1270857167 973423594 1327124936 929421153 1815173609 334327703 1415764778 1658435967 1885325627 1242760978 
967992779 106075067 651281264 1566920808 1420676351 1667591276 396260164 1378373709 1439668113 1311764666 
1082148710 405714634 1886742271 299573044 1563855263 222059382 1720318694 730844891 1506597116 986944464 
1526193299 1756467464 579920934 1227049315 588128132 1055873650 1868295551 1406934216 418556563 2108826346 
1145763072 47285185 1491169410 670428601 1263674325 1451106557 1054261540 169856150 2126894517 1377980827 
808753195 41114675 1229104125 1948210683 268476869 1851959368 1071208102 1169268835 1282666149 87354442 
54083240 1555328418 945503137 1752310013 1559658863 901604258 2118228915 887994942 248329345 743682285 
179414978 1894447411 471628304 947075933 1428575419 1544049213 440283675 43988738 280271465 970122424 
1313932520 239991460 1423518452 860746883 1611949495 587388165 481599641 1439456560 14350211 98282204 
1153571706 963398810 145321916 2070745375 87485829 1576120560 2095760021 1291419077 1652660374 119726312 
177480297 1111633214 233148315 522634628 84703468 18229837 216585682 2139122307 1180849126 1416992445 
1615545633 1912317017 457702758 2315890 2115041590 556434094 807257009 1308846049 229301280 1899717875 
247726108 1811393117 583244079 1395556237 1158276270 1619564894 921926235 211218839 1984124757 275517290 
561951778 1678561734 1800849071 723510226 1158544191 343193604 1568702324 1781096199 562578579 1991168353 
868137751 714518201 16021366 1139923908 232041833 1392724171 1595543496 1943187016 402868814 966623565 
1510514216 1138063579 2092726908 1611212466 1988019150 882740348 1174097415 2121633145 1298761848 1830418897 
1032037449 305344996 574678593 1627571182 2012197687 1659159783 400588035 960967900 820313065 1955152842 
2124794974 1930262720 610581196 1485249609 1951572838 1865710928 1308767070 1167595945 2039103810 172700428 
2046465596 99081839 1201297481 1844812974 124874604 1119893992 847180347 1770985121 721389586 581689477 
389722615 30642572 1900507199 358878772 1409330056 593044680 1026622414 1887112852 1580725739 400698316 
1873464837 428537049 330841325 1468349326 547015739 1931528410 1282412007 407113287 1681090177 769360192 
952787356 1458853049 1858532704 570049683 1799911173 615398763 1051576483 2078823202 723641601 891126722 
253342580 1294798435 718919752 2077540262 1742952318 164788295 1514684219 2108886706 2087860320 150858482 
982966829 539976244 164674119 1812808568 2058615453 771677616 456207444 1162239828 1017281999 587245487 
1117043929 709822122 763426162 405908130 203459070 2094872621 2077555126 1217138872 86687794 17844523 
369198530 361710514 1512709268 1961331671 148975723 1665880998 1613579532 1171302331 1660810430 1153356759 
1083670325 1990160408 1917467139 1427365636 977848805 1918137050 2005393926 1434371632 1589823386 156376735 
1102461060 579195888 3035247 1222732797 1828665696 1061832510 1551928043 1532327782 787008446 1365041470 
373729569 1199078296 589714345 1912772693 1665316884 1650583116 1454005163 717341876 345414100 70185990 
* -> 5 Entries
0: **********************
1: ******************
2: ******************
3: ******************
4: *******************
5: *****************
6: **********************
7: *********************
8: *******************
9: **********************
 */
