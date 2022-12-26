package com.tiankong44.tool.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.gis.entity.Coordinate;
import com.tiankong44.tool.mapper.slave.TestMapper;
import com.tiankong44.tool.test.service.TestService;
import com.tiankong44.tool.util.GisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  13:42
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/test")
    @ResponseBody
    public BaseRes test(@RequestBody String msg) {
        System.out.println("===============");
        int test = testService.test();

        return BaseRes.success(test);
    }


    public static void main(String[] args) {
        String shape = "106.930959,29.828104;106.930882,29.82874;106.930729,29.829174;106.927618,29.832769;106.927057,29.83305;106.923744,29.833214;106.923394,29.833362;106.923182,29.833629;106.922835,29.834413;106.922487,29.834947;106.921927,29.835596;106.921288,29.835893;106.920553,29.836022;106.91999,29.835968;106.918011,29.834767;106.917392,29.834696;106.916713,29.834826;106.915203,29.835637;106.914817,29.835903;106.91474,29.836404;106.915559,29.83835;106.915601,29.840024;106.91541,29.841094;106.914948,29.842096;106.914483,29.842663;106.9134,29.843124;106.912663,29.843153;106.911578,29.842912;106.906688,29.839934;106.905253,29.83949;106.904322,29.839584;106.901498,29.841056;106.901111,29.841472;106.900996,29.841956;106.901001,29.843848;106.900847,29.844416;106.900421,29.844715;106.899338,29.845377;106.899378,29.84608;106.89969,29.846886;106.89977,29.847958;106.899116,29.849862;106.898614,29.850662;106.898304,29.850727;106.895821,29.849271;106.894773,29.849264;106.894387,29.849496;106.893653,29.850428;106.893152,29.85143;106.892688,29.851929;106.892223,29.851893;106.891176,29.851517;106.890553,29.85101;106.889116,29.849528;106.885622,29.846694;106.884301,29.845547;106.882824,29.843127;106.881968,29.841715;106.881616,29.840542;106.881691,29.839605;106.882848,29.837302;106.883773,29.834965;106.883771,29.834094;106.882721,29.832782;106.879649,29.828309;106.879298,29.827135;106.879564,29.825161;106.878942,29.824521;106.878128,29.824047;106.876964,29.823772;106.876228,29.823935;106.873794,29.826764;106.873447,29.827666;106.873177,29.828367;106.872947,29.829069;106.872369,29.830505;106.869038,29.831889;106.867915,29.831849;106.867295,29.831711;106.866791,29.831473;106.866441,29.830969;106.866517,29.8303;106.869069,29.828006;106.869533,29.827641;106.869571,29.827273;106.869454,29.826904;106.869105,29.826835;106.867865,29.826827;106.867127,29.826688;106.866507,29.826116;106.866156,29.825443;106.865922,29.824605;106.86561,29.823767;106.865143,29.823195;106.864483,29.822454;106.864015,29.82158;106.863585,29.81987;106.863157,29.819265;106.860091,29.81717;106.859354,29.817098;106.858619,29.817662;106.857769,29.818762;106.857034,29.819192;106.856452,29.819188;106.855367,29.81888;106.849583,29.814626;106.848613,29.814218;106.847916,29.81438;106.846947,29.814676;106.846171,29.814637;106.845668,29.814299;106.837934,29.80521;106.836306,29.804932;106.835724,29.804962;106.835221,29.805226;106.834835,29.805524;106.834797,29.80596;106.834993,29.8071;106.834955,29.807601;106.834685,29.807967;106.831048,29.810253;106.830506,29.810317;106.829301,29.809104;106.828214,29.808528;106.82775,29.808625;106.82431,29.812185;106.824311,29.81262;106.827844,29.815321;106.828193,29.815357;106.828348,29.815258;106.828346,29.814722;106.828189,29.814085;106.828227,29.813683;106.828498,29.813518;106.829274,29.81369;106.830244,29.814132;106.834903,29.817744;106.834943,29.818313;106.834595,29.818813;106.834169,29.819178;106.830685,29.820595;106.82991,29.820691;106.828631,29.820247;106.827544,29.819738;106.826576,29.819866;106.824214,29.820954;106.823634,29.82132;106.823131,29.821317;106.821617,29.820469;106.820996,29.819996;106.820492,29.820027;106.819177,29.820989;106.818481,29.821353;106.817861,29.821449;106.813715,29.822058;106.812707,29.822052;106.811662,29.821978;106.810615,29.821637;106.805646,29.818559;106.804948,29.818555;106.804445,29.81892;106.803982,29.819653;106.801087,29.824489;106.800547,29.825523;106.800045,29.825788;106.799657,29.825785;106.796591,29.823556;106.796047,29.823418;106.795969,29.823518;106.796125,29.823921;106.798154,29.829156;106.798903,29.834752;106.79937,29.835659;106.80318,29.840203;106.804268,29.842118;106.805866,29.845743;106.808426,29.854848;106.80835,29.855233;106.808079,29.855532;106.807731,29.855698;106.802365,29.8564;106.801939,29.856548;106.801727,29.856865;106.80165,29.857149;106.801709,29.857618;106.802391,29.859012;106.802527,29.859481;106.802392,29.859715;106.802044,29.859746;106.801501,29.859676;106.801113,29.859439;106.800374,29.85853;106.799715,29.858124;106.799094,29.857819;106.797174,29.857137;106.795933,29.857028;106.79508,29.85709;106.794539,29.857271;106.793939,29.857601;106.793494,29.858035;106.792971,29.858383;106.791268,29.858908;106.790687,29.858987;106.790261,29.858968;106.788551,29.857568;106.787893,29.857279;106.787388,29.857142;106.78671,29.857087;106.785974,29.857133;106.785626,29.857264;106.784582,29.858362;106.784272,29.858929;106.784351,29.859499;106.785051,29.860106;106.790174,29.86352;106.790642,29.86436;106.791771,29.867079;106.791733,29.867447;106.791503,29.867914;106.791271,29.868281;106.78705,29.869526;106.786353,29.869789;106.785967,29.870189;106.785812,29.870757;106.785852,29.871393;106.786049,29.872164;106.786166,29.872868;106.787875,29.874319;106.788264,29.875124;106.788227,29.875426;106.787878,29.875691;106.78478,29.876608;106.784045,29.876805;106.783037,29.8773;106.781066,29.878995;106.779521,29.88126;106.779485,29.882064;106.78042,29.884313;106.780421,29.884614;106.779879,29.884845;106.779259,29.884774;106.777047,29.883588;106.776271,29.88365;106.775845,29.883747;106.775459,29.884046;106.775073,29.884512;106.775152,29.885216;106.776551,29.887033;106.776512,29.887367;106.776242,29.887667;106.773728,29.889324;106.773574,29.889692;106.773653,29.890596;106.775607,29.897304;106.775609,29.898275;106.775168,29.900331;106.774937,29.900698;106.774415,29.901113;106.770698,29.902511;106.770136,29.902575;106.769516,29.90247;106.766972,29.900126;106.76639,29.899721;106.765847,29.899717;106.764723,29.89971;106.763676,29.899435;106.757005,29.896647;106.755917,29.895937;106.755373,29.89513;106.754944,29.893956;106.754438,29.89335;106.753663,29.89291;106.75281,29.892737;106.752074,29.892766;106.751415,29.892962;106.750757,29.893259;106.749943,29.893522;106.748898,29.893649;106.747503,29.89364;106.746767,29.893536;106.745912,29.893228;106.745834,29.892826;106.746337,29.892293;106.749242,29.891442;106.749977,29.891212;106.750479,29.890646;106.750516,29.889542;106.750243,29.88867;106.749349,29.887927;106.748302,29.887485;106.747293,29.887178;106.74706,29.886841;106.748294,29.883903;106.748836,29.883639;106.750581,29.884119;106.751162,29.884156;106.751587,29.883858;106.752437,29.883093;106.753212,29.882897;106.754763,29.88274;106.756775,29.881715;106.757587,29.88095;106.757624,29.880281;106.757429,29.879912;106.756963,29.879507;106.755102,29.879026;106.753627,29.877811;106.75312,29.876837;106.752958,29.873756;106.7528,29.872684;106.752101,29.872144;106.751519,29.871672;106.751324,29.871269;106.752794,29.869671;106.752985,29.869237;106.752868,29.868969;106.751509,29.867738;106.750986,29.867417;106.750675,29.866946;106.751254,29.865963;106.7516,29.865378;106.751445,29.865126;106.750979,29.864822;106.750476,29.864602;106.7497,29.864379;106.747122,29.864196;106.746482,29.864141;106.746308,29.864006;106.746481,29.86374;106.748184,29.862679;106.748686,29.862113;106.748763,29.861745;106.748529,29.861408;106.748161,29.861173;106.747811,29.860802;106.747655,29.860299;106.747808,29.859463;106.748154,29.85856;106.750955,29.854964;106.750955,29.854628;106.750742,29.854376;106.750508,29.854341;106.750316,29.85439;106.74871,29.855852;106.748265,29.856169;106.747937,29.856317;106.747548,29.856315;106.745745,29.8557;106.744659,29.855559;106.743962,29.855655;106.743265,29.855986;106.742685,29.856149;106.742025,29.856112;106.741482,29.85584;106.740123,29.854727;106.740006,29.854257;106.7402,29.853924;106.740431,29.853925;106.741284,29.853998;106.741943,29.853902;106.742368,29.85367;106.743374,29.85294;106.74407,29.852074;106.744223,29.851372;106.743873,29.850868;106.736463,29.847271;106.735338,29.847063;106.734796,29.847194;106.734177,29.847524;106.733057,29.849291;106.732632,29.849724;106.732322,29.849755;106.731973,29.849586;106.731231,29.847204;106.730648,29.846832;106.729331,29.846857;106.728789,29.847188;106.728403,29.847721;106.728095,29.848422;106.727748,29.849392;106.727639,29.852169;106.727523,29.852638;106.727214,29.852936;106.724503,29.853489;106.723998,29.853719;106.723769,29.854388;106.723931,29.857368;106.723119,29.858167;106.722771,29.858399;106.722267,29.858461;106.721918,29.85846;106.721336,29.858254;106.720095,29.857845;106.719863,29.857944;106.719709,29.858277;106.719903,29.858613;106.720681,29.859723;106.720721,29.860293;106.720567,29.860693;106.720142,29.861059;106.719523,29.861457;106.715031,29.862901;106.713561,29.863895;106.712979,29.863925;106.71263,29.863889;106.710885,29.863276;106.710187,29.863171;106.709374,29.863266;106.707478,29.864089;106.706858,29.864487;106.706394,29.865187;106.706125,29.866022;106.705971,29.866624;106.705508,29.866855;106.703009,29.867241;106.702757,29.867357;106.702622,29.867674;106.700616,29.871393;106.700345,29.871559;106.700093,29.871557;106.699744,29.871421;106.696095,29.868954;106.69485,29.866736;106.692112,29.864626;106.691453,29.864538;106.691047,29.86462;106.687911,29.866173;106.687892,29.866323;106.687932,29.866508;106.690226,29.869686;106.690188,29.870087;106.689975,29.870371;106.689588,29.870536;106.687283,29.870822;106.686683,29.871036;106.684458,29.872596;106.6838,29.872758;106.681649,29.872645;106.681087,29.872658;106.679944,29.873186;106.679655,29.873402;106.679656,29.87372;106.68024,29.875113;106.680145,29.875631;106.679932,29.876048;106.676605,29.87837;106.676217,29.878518;106.675907,29.878483;106.675016,29.878142;106.674453,29.878005;106.67391,29.878118;106.673349,29.878316;106.672807,29.878446;106.671897,29.878658;106.668952,29.878975;106.66841,29.878971;106.667887,29.878867;106.667499,29.878647;106.667208,29.878394;106.666915,29.878074;106.666625,29.877922;106.664688,29.878077;106.664183,29.877906;106.663911,29.877335;106.664794,29.874194;106.664754,29.873558;106.664482,29.872953;106.663821,29.87228;106.661026,29.870521;106.660291,29.870449;106.659788,29.87078;106.659051,29.871244;106.658394,29.871341;106.657966,29.871204;106.657423,29.870832;106.656879,29.870059;106.656605,29.869387;106.65687,29.866443;106.656637,29.866006;106.65621,29.866037;106.655979,29.866203;106.655902,29.866705;106.655709,29.867273;106.655245,29.867638;106.654897,29.867635;106.654354,29.867498;106.651286,29.865134;106.651286,29.864866;106.651479,29.864399;106.653799,29.862306;106.653799,29.862104;106.653603,29.861868;106.6531,29.861564;106.651896,29.860418;106.648626,29.854471;106.648547,29.853868;106.648817,29.853167;106.649009,29.852365;106.648891,29.851728;106.647762,29.849678;106.646946,29.848736;106.646364,29.84823;106.645665,29.847891;106.645084,29.84782;106.644386,29.847849;106.642373,29.848807;106.641793,29.849004;106.641405,29.848968;106.641016,29.84853;106.640782,29.847893;106.640779,29.846721;106.640702,29.846218;106.637978,29.841848;106.637123,29.840905;106.634911,29.839752;106.63402,29.839713;106.633245,29.839742;106.632858,29.840074;106.632433,29.840707;106.6301,29.845379;106.629616,29.845593;106.626536,29.845926;106.626013,29.846073;106.621526,29.849442;106.621527,29.849877;106.621799,29.850348;106.627704,29.856311;106.62786,29.856781;106.627784,29.857517;106.626802,29.860189;106.626396,29.860504;106.625622,29.86075;106.622968,29.861152;106.622116,29.861263;106.621498,29.861577;106.619275,29.864224;106.615102,29.869721;106.614639,29.870555;106.614059,29.871054;106.612278,29.871477;106.612007,29.871643;106.612047,29.872045;106.61306,29.874294;106.612828,29.874695;106.612479,29.87476;106.612015,29.87469;106.611664,29.87432;106.610653,29.872539;106.609411,29.871928;106.60879,29.87159;106.607429,29.869706;106.606731,29.869367;106.605414,29.869057;106.60483,29.868652;106.604636,29.868316;106.60405,29.866236;106.602026,29.862741;106.600783,29.861427;106.600122,29.860988;106.599076,29.860847;106.598417,29.860809;106.59768,29.86057;106.594258,29.855493;106.594296,29.855025;106.595068,29.853925;106.595067,29.853456;106.594988,29.852886;106.593319,29.851771;106.592854,29.851701;106.592428,29.851832;106.589294,29.854222;106.588597,29.854452;106.588055,29.854381;106.586424,29.853232;106.585727,29.853261;106.585146,29.853291;106.584255,29.853419;106.583519,29.853883;106.582439,29.855951;106.581609,29.856766;106.581162,29.85683;106.580755,29.856794;106.576625,29.855295;106.576179,29.855308;106.575656,29.855506;106.573319,29.858587;106.572797,29.859187;106.572275,29.859401;106.571713,29.859347;106.569715,29.858581;106.569154,29.858527;106.568844,29.858559;106.567547,29.85927;106.566656,29.859549;106.566268,29.859513;106.562814,29.857483;106.562272,29.857479;106.561555,29.857558;106.559582,29.858768;106.559214,29.858966;106.558807,29.858963;106.557547,29.858604;106.557159,29.858685;106.556115,29.859448;106.55567,29.859663;106.555321,29.859694;106.554932,29.859591;106.552934,29.858307;106.552255,29.858002;106.549329,29.857832;106.548572,29.85781;106.547817,29.857973;106.545516,29.859498;106.544876,29.859845;106.544411,29.859893;106.543889,29.859655;106.543344,29.858948;106.542741,29.857806;106.542405,29.855277;106.542017,29.854755;106.54157,29.854401;106.540911,29.85433;106.540504,29.854327;106.539962,29.854508;106.539342,29.854638;106.538471,29.854632;106.535467,29.854562;106.530877,29.855553;106.529986,29.855765;106.523561,29.859155;106.522748,29.859233;106.522263,29.85918;106.52172,29.858959;106.518836,29.855489;106.517756,29.851222;106.517053,29.849148;106.51582,29.84711;106.514324,29.845201;106.513779,29.84426;106.513482,29.84163;106.513287,29.84101;106.510684,29.838382;106.510139,29.837407;106.509317,29.833937;106.508441,29.832308;106.505976,29.830402;106.503664,29.827658;106.502867,29.826883;106.501893,29.8245;106.50162,29.82403;106.499912,29.82288;106.498845,29.822204;106.495907,29.817615;106.495404,29.817344;106.494842,29.817274;106.494473,29.817355;106.494184,29.817588;106.493893,29.81792;106.492934,29.821998;106.492375,29.822815;106.491929,29.823181;106.491465,29.823446;106.491058,29.823493;106.489527,29.823383;106.489004,29.82338;106.488346,29.82361;106.484205,29.826194;106.483586,29.826224;106.48316,29.826188;106.482656,29.826084;106.481996,29.825677;106.477765,29.822737;106.477221,29.822299;106.474467,29.821143;106.474078,29.820705;106.473836,29.816753;106.473485,29.815914;106.465676,29.807695;106.465598,29.80736;106.465791,29.806926;106.477658,29.79455;106.47758,29.794248;106.477346,29.794113;106.476959,29.794044;106.4732,29.793951;106.472386,29.79388;106.471378,29.793571;106.468233,29.79171;106.467105,29.789259;106.463843,29.786459;106.459526,29.780238;106.458049,29.778185;106.456184,29.776433;106.451833,29.772253;106.451755,29.771583;106.45271,29.765831;106.45263,29.764961;106.452435,29.764156;106.450648,29.762504;106.449172,29.761323;106.448745,29.760784;106.448744,29.760316;106.448741,29.759177;106.447884,29.757398;106.447844,29.756761;106.448576,29.755092;106.448768,29.75439;106.448688,29.753285;106.448571,29.752782;106.448144,29.752478;106.447562,29.752274;106.446126,29.751896;106.445661,29.751625;106.445428,29.751223;106.445615,29.748478;106.444954,29.743502;106.444321,29.742109;106.442065,29.738815;106.441317,29.733755;106.441348,29.730357;106.441172,29.729871;106.44053,29.728812;106.44053,29.728561;106.440684,29.728361;106.440897,29.728145;106.441555,29.727865;106.442039,29.727884;106.445725,29.729698;106.448095,29.731956;106.448793,29.732396;106.449568,29.732368;106.451894,29.732215;106.452668,29.731953;106.45348,29.731422;106.454254,29.730624;106.455105,29.73006;106.455868,29.729705;106.456631,29.729442;106.458692,29.729282;106.458778,29.72924;106.458822,29.729141;106.45886,29.728725;106.458737,29.728231;106.458664,29.727753;106.458516,29.727107;106.458732,29.723622;106.458534,29.721746;106.457442,29.719162;106.45515,29.716803;106.455149,29.716402;106.455342,29.715901;106.456851,29.714739;106.459252,29.71452;106.460323,29.71505;106.460479,29.715081;106.460698,29.71507;106.460946,29.715005;106.461184,29.714908;106.461346,29.714755;106.462353,29.711746;106.463181,29.709036;106.464622,29.70425;106.465639,29.701743;106.467428,29.698007;106.467979,29.69724;106.46804,29.696829;106.467843,29.696641;106.462224,29.692747;106.461097,29.691735;106.459466,29.689984;106.456075,29.68253;106.4549,29.676865;106.454934,29.675191;106.455202,29.673853;106.455896,29.672485;106.46378,29.663264;106.467955,29.658972;106.468689,29.658039;106.469848,29.656306;106.470501,29.654101;106.470499,29.653197;106.470458,29.652226;106.470145,29.651253;106.46882,29.648198;106.464854,29.642615;106.456076,29.634389;106.451569,29.629205;106.450127,29.625915;106.450123,29.624241;106.45039,29.622703;106.451085,29.621435;106.45209,29.620437;106.453367,29.619608;106.46088,29.617481;106.462273,29.616452;106.462853,29.615987;106.463355,29.61512;106.463507,29.614117;106.461904,29.608014;106.450234,29.589995;106.450542,29.588658;106.451391,29.587224;106.455879,29.583838;106.464507,29.577969;106.476838,29.565429;106.487433,29.556291;106.488441,29.555762;106.489602,29.555334;106.490609,29.555106;106.492004,29.555115;106.500109,29.557477;106.500962,29.557482;106.502938,29.557327;106.514325,29.554655;106.521763,29.553029;106.526567,29.552926;106.529512,29.55298;106.531063,29.553123;106.532924,29.553571;106.535795,29.554895;106.538865,29.558296;106.540809,29.561255;106.543182,29.564953;106.545977,29.566712;106.548536,29.567431;106.554156,29.567902;106.558946,29.568004;106.560061,29.568178;106.561176,29.568352;106.565808,29.568913;106.566911,29.56906;106.56737,29.568965;106.569921,29.567629;106.571871,29.566405;106.573306,29.566173;106.574742,29.565941;106.580543,29.565997;106.584267,29.567494;106.585045,29.568704;106.585126,29.570244;106.585052,29.571583;106.584667,29.572852;106.584283,29.574256;106.583204,29.576392;106.582432,29.57806;106.580968,29.581866;106.580285,29.587687;106.581308,29.594054;106.584035,29.600164;106.589788,29.607367;106.599104,29.613653;106.607713,29.616187;106.612907,29.616822;106.616318,29.616744;106.618641,29.616223;106.621314,29.615471;106.623172,29.61488;106.624797,29.613786;106.62615,29.612087;106.628538,29.606244;106.629921,29.600896;106.636871,29.590261;106.638263,29.589266;106.640431,29.58821;106.642097,29.587918;106.64454,29.588102;106.655011,29.591653;106.656794,29.591932;106.657646,29.591937;106.658537,29.591608;106.659504,29.590945;106.662208,29.58728;106.669302,29.571926;106.675329,29.564198;106.677962,29.562876;106.680362,29.562355;106.683153,29.562106;106.687028,29.562465;106.689277,29.563016;106.691761,29.564437;106.702323,29.573143;106.705585,29.575507;106.711557,29.578157;106.732107,29.582842;106.73366,29.583924;106.73607,29.586617;106.75286,29.606745;106.757516,29.609084;106.759534,29.609767;106.762324,29.610254;106.772321,29.609617;106.798699,29.604329;106.800365,29.604005;106.801295,29.604011;106.802381,29.604051;106.803389,29.604025;106.804511,29.603797;106.807028,29.602909;106.807764,29.60278;106.808306,29.602783;106.808927,29.602921;106.809548,29.603193;106.810053,29.603799;106.811378,29.606452;106.81134,29.607322;106.810916,29.608156;106.810647,29.608891;106.810493,29.60956;106.810572,29.610096;106.810844,29.610432;106.811193,29.610669;106.811774,29.610673;106.813285,29.610281;106.813827,29.610284;106.814332,29.610622;106.814566,29.611025;106.814528,29.611661;106.812752,29.614328;106.812792,29.614696;106.812908,29.614931;106.814499,29.615812;106.814849,29.616317;106.81485,29.616752;106.814658,29.617219;106.814621,29.617989;106.814699,29.618425;106.815126,29.618729;106.81594,29.618734;106.81749,29.618476;106.81811,29.61848;106.818614,29.618651;106.818848,29.619288;106.818812,29.620326;106.81905,29.622671;106.820258,29.62539;106.820957,29.625997;106.821616,29.626068;106.823242,29.625175;106.824171,29.625215;106.824831,29.625654;106.825298,29.62626;106.82573,29.628773;106.826391,29.629548;106.826973,29.62982;106.827709,29.629691;106.829567,29.628832;106.830458,29.628805;106.831311,29.629011;106.832669,29.62979;106.834535,29.63171;106.838345,29.637058;106.844093,29.642418;106.845766,29.644605;106.848333,29.64894;106.852761,29.653187;106.853421,29.65376;106.854545,29.653868;106.860901,29.654008;106.861328,29.654312;106.861639,29.654616;106.86164,29.655285;106.86122,29.657592;106.861068,29.658462;106.861222,29.658764;106.861533,29.658867;106.861881,29.658835;106.863895,29.658045;106.864283,29.658047;106.864554,29.658417;106.864914,29.663005;106.865188,29.664245;106.866941,29.66737;106.866595,29.668975;106.866868,29.669546;106.867256,29.669783;106.867953,29.669887;106.868613,29.669892;106.871013,29.669204;106.87144,29.669508;106.872762,29.671391;106.873538,29.671731;106.875243,29.671642;106.875709,29.671913;106.876137,29.672518;106.879984,29.676962;106.879985,29.677564;106.879754,29.678098;106.878594,29.679129;106.878402,29.679831;106.878636,29.680401;106.879375,29.681645;106.87926,29.682012;106.877443,29.683641;106.877058,29.684843;106.877137,29.685748;106.877294,29.686686;106.879625,29.68871;106.879858,29.68918;106.879511,29.689948;106.877114,29.692108;106.876185,29.692872;106.876226,29.693642;106.878131,29.696232;106.878868,29.696237;106.88061,29.695612;106.881036,29.695582;106.881851,29.695821;106.883637,29.697473;106.883871,29.697977;106.883834,29.698614;106.883525,29.699281;106.88341,29.699882;106.883722,29.700421;106.886596,29.70305;106.886984,29.703555;106.886986,29.704258;106.887337,29.704963;106.888152,29.705605;106.889084,29.706481;106.888853,29.706881;106.888156,29.707446;106.887189,29.707975;106.88231,29.709819;106.882001,29.710084;106.881926,29.710787;106.882198,29.711659;106.884107,29.715689;106.884341,29.716259;106.884265,29.716995;106.884228,29.717397;106.884422,29.717766;106.886052,29.718714;106.886517,29.718751;106.887524,29.718389;106.888066,29.718325;106.888841,29.718397;106.889423,29.718535;106.892568,29.7209;106.892879,29.721336;106.89288,29.721705;106.891179,29.723467;106.890947,29.723901;106.891219,29.724472;106.892694,29.725653;106.892657,29.726021;106.892195,29.727223;106.892158,29.727759;106.892314,29.728397;106.893287,29.729776;106.893752,29.730047;106.894334,29.73005;106.89565,29.729624;106.896115,29.72966;106.896659,29.730132;106.899383,29.735004;106.899346,29.735975;106.89931,29.736644;106.898693,29.738096;106.898423,29.738446;106.898074,29.738578;106.895246,29.739296;106.892693,29.740719;106.892035,29.741015;106.889671,29.741267;106.889362,29.7416;106.889557,29.74207;106.891035,29.74449;106.891037,29.74526;106.890962,29.746264;106.890693,29.747199;106.891215,29.754668;106.891527,29.755674;106.892227,29.756616;106.895062,29.759045;106.896113,29.760993;106.900739,29.767151;106.900896,29.767721;106.901014,29.768491;106.901132,29.76943;106.905569,29.77709;106.910468,29.784118;106.910469,29.78452;106.909852,29.785755;106.909815,29.786323;106.910087,29.78676;106.912767,29.789088;106.912923,29.78949;106.912924,29.789892;106.912072,29.790891;106.911881,29.791358;106.911998,29.791861;106.912698,29.792904;106.912699,29.793339;106.912661,29.793874;106.912431,29.794442;106.912393,29.79491;106.912588,29.795313;106.912977,29.795952;106.913677,29.796827;106.917091,29.798723;106.917442,29.799328;106.917716,29.800502;106.920377,29.811533;106.925169,29.821741;106.925598,29.822982;106.926219,29.823622;106.928664,29.824373;106.929245,29.824946;106.930959,29.828104";
        String[] split = shape.split(";");
        List<Coordinate> coordinateList = new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(",");
            Coordinate coordinate = new Coordinate();
            coordinate.setLongitude(Double.parseDouble(split1[0]));
            coordinate.setLatitude(Double.parseDouble(split1[1]));
            //coordinate = GisUtil.gcj02ToGps84(coordinate);
            coordinate = GisUtil.gcj02ToBd09(coordinate);
            coordinateList.add(coordinate);
        }
        System.out.println(JSONArray.toJSON(coordinateList));
    }
}
