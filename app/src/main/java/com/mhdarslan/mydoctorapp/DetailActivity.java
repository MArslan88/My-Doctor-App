package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionDiseases;
    private TextView detailsHeadingTxt;
    private TextView introText, causesText, symptomsText, homeRemedyText, tibeNabviText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailsHeadingTxt = findViewById(R.id.detailsHeadingTxt);
        introText = findViewById(R.id.introText);
        causesText = findViewById(R.id.causesText);
        symptomsText = findViewById(R.id.symptomsText);
        homeRemedyText = findViewById(R.id.homeRemedyText);
        tibeNabviText = findViewById(R.id.tibeNabviText);


        Intent intent = getIntent();
        positionDiseases = intent.getIntExtra("position",0);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle(HomeTreatmentActivity.listOfDiseases[positionDiseases]);

        // Main heading Text according to Intent position
        detailsHeadingTxt.setText("Get to know about \n"+HomeTreatmentActivity.listOfDiseases[positionDiseases]);

        // Intro Array data
        String[] introData = {
                "Headache disorders are among the most common disorders of the nervous system. It has been estimated that almost half of the adult population have had a headache at least once within the last year. Headache disorders, which are characterized by recurrent headache, are associated with personal and societal burdens of pain, disability, damaged quality of life, and financial cost. Worldwide, a minority of people with headache disorders are diagnosed appropriately by a health-care provider. Headache has been underestimated, under-recognized and under-treated throughout the world.",

                "Rise in the body temperature than normal is considered as the condition as the of fever. Generally, the normal temperature of human being is 98.6 Fahrenheit or 37 Celsius, it may vary in a small amount between people to people. When there is small rise in the body temperature, it is considered as mild fever or low-grade fever and only when the body temperature is above 100.4F or 38C, it is medically considered fever. You don’t have to take medicines and treat the low-grade fever unless you have faced the symptoms of fever. Basically, fever is caused when your body is fighting an infection such as flu",

                "A cough, also known as tussis, is a voluntary or involuntary act that clears the throat and breathing passage of foreign particles, microbes, irritants, fluids, and mucus; it is a rapid expulsion of air from the lungs.",

                "Throat infection is an infection of the oral pharynx & tonsils mostly by streptococcus resulting in septic sore throat, strep throat, streptococcal sore throat, tonsillitis pharyngitis, raw throat & inflammation of the fauces & pharynx. A sore throat is a pain or irritation of the throat. It may due to pharyngitis it can also appear as a result of trauma, diphtheria, or other conditions.",

                "Influenza is commonly known as ‘’the flu’’, is an infectious disease caused by an influenza.  Influenza, or flu, is a respiratory illness that results from a viral infection. Flu is highly contagious and spreads through respiratory droplets. A person can pass it on while talking or through physical contact, such as shaking hands.",

                "A toothache or tooth pain or dental pain is a pain in around the teeth and jaws that’s may caused by dental diseases or pain referred to teeth by non-dental diseases. Tooth ache is caused when the delicate, central pulp of the tooth is inflamed. It contains numerous nerve connections, which are naturally sensitive. When the tooth gets damaged and infected, the nerves start sending pain response to indicate the tooth the damaged.",

                "Gastrointestinal diseases refer to diseases involving the gastro intestinal tract, namely the esophagus, stomach, small intestine, large intestine & rectum & the accessory organs of digestion, the liver, gallbladder & pancreas.",

                "There are many eye diseases from minor to major mostly caused by bacteria or viral infection, causing pain, inflammation of eyes, watering of eyes (ehiphora), increase in eye pressure, visual impairment & etc.",

                "Conjunctivitis, also known as pin eye, is inflammation of the outermost layer of the white part of the eye and the inner surface of the eyelid. It makes the eye appear pink or reddish. There may also be pain, burning, scratchiness. The affected eye may have increased tears or be ‘’stuck’’ in the morning. Swelling of the white part of the eye may also occur.",

                "Insomnia is a sleep disorder that is characterized by difficulty in sleep or staying asleep. People with insomnia have one or more of the following symptoms: - Difficulty falling asleep, waking up often during the night & having trouble going back to sleep, waking up too early in the morning, feeling tired upon waking.",

                "Pleurisy is an inflammatory condition of the pleura (covering layers of the lungs), which impairs their lubricating function causes pain when breathing. It is caused by pneumonia other diseases of the chest or abdomen. Angina or chest pain is the pain comes from the heart. Every year about 20,000 people in the UK develop angina for the first time. It is more common in people over the age of 50 years. Now it is common in men than women.",

                "Diabetes is a disease that affects your body’s ability to produce or use insulin. Insulin is a hormone. When your body turns the food, you eat into energy (also called sugar or glucose), insulin is released to help transport this energy to the cells. Insulin acts as a “key.” Its chemical message tells the cell to open & receive glucose. If you produce little or no insulin, or are insulin resistant, too much sugar remains in your blood. Blood glucose levels are higher than normal for individuals with diabetes. There are two main types of diabetes: Type 1 & Type 2.",

                "Kidney stones (also called renal calculi, nephrolithiasis or urolithiasis) are hard deposits made of minerals and salts that form inside your kidneys. Kidney stones can affect any part of your urinary tract from your kidneys to your bladder. Often, stones form when the urine becomes concentrated, allowing minerals to crystallize and stick together. Passing kidney stones can be quite painful, but the stones usually cause no permanent damage if they're recognized in a timely fashion.",

                "The head lice are tiny, wingless parasitic insect that lives among human hairs & feeds on tiny amounts of blood drawn from the scalp. Lice (the plural of louse) are a very common problem, especially for kids. They're contagious, annoying & sometimes tough to get rid of. Lice aren't dangerous. They don't spread disease, although their bites can make a child's scalp itchy & irritated & scratching can lead to infection. It's best to treat head lice quickly once they're found because they can spread easily from person to person.",

                "Burns are an injury caused by exposure to heat or flame. A burn is a type of injury to skin, or other tissues, caused by heat, electricity, chemicals, friction, or radiation. Burns that affect only the superficial skin layers are known as superficial or first-degree burns. When the injury extends into some of the underlying layers, it is described as a partial-thickness or second-degree burn. In a full-thickness or third-degree burn, the injury extends to all layers of the skin. A fourth-degree burn additionally involves injury to deeper tissues, such as muscle, tendons, or bone.",

                "Knee pain is a common complaint that affects people of all ages. Knee pain may be the result of an injury, such as a ruptured ligament or torn cartilage. Medical conditions including arthritis, gout and infections also can cause knee pain.",

                "Blood pressure is the measure of the force of blood pushing against blood vessel walls. The heart pumps blood into the arteries (blood vessels), which carry the blood throughout the body. High blood pressure, also called hypertension, is dangerous because it makes the heart work harder to pump blood out to the body & contributes to hardening of the arteries, or atherosclerosis, to stroke, kidney disease & to the development of heart failure.",

                "Acne is a skin condition that occurs when your hair follicles become plugged with oil and dead skin cells. It causes whiteheads, blackheads or pimples. Acne is most common among teenagers, though it affects people of all ages. Effective acne treatments are available, but acne can be persistent. The pimples and bumps heal slowly, and when one begins to go away, others seem to crop up. Depending on its severity, acne can cause emotional distress and scar the skin. The earlier you start treatment, the lower your risk of such problems.",

                "Constipation is a condition in which there is difficulty in emptying the bowels (intestines), usually associated with hardened faeces. It is a (Pathology) infrequent or difficult evacuation of the bowels, with hard faeces, caused by functional or organic disorders or improper diet. Common causes are insufficient dietary fiber intake, inadequate fluid intake & decreased physical activity, side effects of medications, hypothyroidism & obstruction by colorectal cancer.",

                "Depression is a state of low mood & aversion to activity that can affect a person's thoughts, behavior, feelings & sense of well-being. People with depressed mood can feel sad, anxious, empty, hopeless, helpless, worthless, guilty, irritable, ashamed or restless. Also called major depressive disorder or clinical depression, it affects how you feel, think and behave and can lead to a variety of emotional and physical problems. You may have trouble doing normal day-to-day activities, and sometimes you may feel as if life isn't worth living."
        };



        // causes array data
        String[] causesData = {
                "•\tTension/stress\n" +
                        "•\tFatigue\n" +
                        "•\tLashing lights\n" +
                        "•\tCaffeine\n" +
                        "•\tHormonal changes\n" +
                        "•\tLack of sleep/food\n" +
                        "•\tOveruse of pain medication",

                "•\tInfection\n" +
                        "•\tCold and flu\n" +
                        "•\tStrep throat\n" +
                        "•\tChronic bronchitis\n" +
                        "•\tRSV (Respiratory syncytial virus) infection",

                "•\tFever\n" +
                        "•\tCommon cold\n" +
                        "•\tSinus infection\n" +
                        "•\tSeasonal change\n" +
                        "•\tbacterial infection\n" +
                        "•\tSmoking and drinking alcohol",

                "•\tFlu\n" +
                        "•\tIrritants\n" +
                        "•\tDryness\n" +
                        "•\tAllergies\n" +
                        "•\tMeasles\n" +
                        "•\tChickenpox\n" +
                        "•\tCommon cold",

                "•\tThe Influenza virus spreads from one person to the other through droplets in the air, when and infected person coughs or sneezes. The virus enters in your body, in case you happen to inhale any of these droplets. At times, talking can also cause the virus to get transmitted from one person to other.",

                "•\tTooth decay\n" +
                        "•\tA cracked tooth\n" +
                        "•\tInfected gums\n" +
                        "•\tHabitual clenching and grinding of teeth.\n" +
                        "•\tPhysical trauma to mouth or jaw.\n" +
                        "•\tDamaged filling of the tooth. This exposes the sensitive nerves in the tooth pulp.\n" +
                        "•\tGum diseases, which cause erosion of teeth and bacterial infections.\n" +
                        "•\tSinusitis can cause infected matter to leak into the mouth and jaw area.\n" +
                        "•\tJoint diseases which can affect jaw joints.\n" +
                        "•\tWisdom tooth pain when they start emerging.\n" +
                        "•\tThe emergence of wisdom teeth pushes against other teeth and can sometimes cause injuries. Consult a dentist in such cases.\n" +
                        "•\tImproper dental hygiene, in which they are not cleaned properly. The buildup of matter ends up upsetting natural pH of the mouth, thus causing erosion and providing an ideal environment for bacterial buildup.",

                "•\tSexual act of anilingus\n" +
                        "•\tUncooked or un washed food\n" +
                        "•\tContaminated water or hands\n" +
                        "•\tSkin contact with larva infected soil",

                "•\tLyme diseases\n" +
                        "•\tAllergies\n" +
                        "•\tTuberculosis\n" +
                        "•\tAcanthamoeba",

                "•\tViruses\n" +
                        "•\tBacteria\n" +
                        "•\tAllergies\n" +
                        "•\tA foreign object in the eye\n" +
                        "•\tA chemical splash in the eye",

                "•\tPain, injury\n" +
                        "•\tHeart diseases\n" +
                        "•\tPoor sleep injury\n" +
                        "•\tRestless legs syndrome\n" +
                        "•\tPrevious thoracic surgery\n" +
                        "•\tUse of psychoactive drugs\n" +
                        "•\tPeriodic limb movement disorder\n" +
                        "•\tUse of or withdrawal from alcohol and other sedatives\n" +
                        "•\tDeviated nasal septum and nocturnal breathing disorders",

                "•\tAngina or chest pain caused by reduced blood flow to the heart is known as angina pectoris or simply angina.",

                "•\tObesity\n" +
                        "•\tLack of exercise\n" +
                        "•\tGenetic susceptibility\n" +
                        "•\tEnvironmental factors\n" +
                        "•\tDamage to or removal of the pancreas\n" +
                        "•\tAutoimmune destruction of beta cells\n" +
                        "•\tAbnormal glucose production by the liver\n" +
                        "•\tGenetic mutations affecting bets cells, insulin, and insulin action",

                "•\tHeredity\n" +
                        "•\tDad diet\n" +
                        "•\tMedications\n" +
                        "•\tGeographical location",

                "A head lice infestation results from the direct transfer of lice from the hair of one person to the hair of another through head-to-head contact. indirect transmission is uncommon, but lice may spread from one person to another by items such as:\n\n" +
                        "•\tHats and scarves\n" +
                        "•\tBrushes and combs\n" +
                        "•\tHair accessories\n" +
                        "•\tHeadphones\n" +
                        "•\tPillows, towels and upholstery",

                "•\tFire\n" +
                        "•\tHot liquid or steam\n" +
                        "•\tHot metal, glass or other objects\n" +
                        "•\tElectrical currents\n" +
                        "•\tRadiation, such as that from X-rays\n" +
                        "•\tSunlight or other sources of ultraviolet radiation, such as a tanning bed\n" +
                        "•\tChemicals such as strong acids, lye, paint thinner or gasoline\n" +
                        "•\tAbuse",

                "•\tWeakened bone structure\n" +
                        "•\tLigament injuries\n" +
                        "•\tFractures\n" +
                        "•\tMeniscus injuries\n" +
                        "•\tKnee bursitis\n" +
                        "•\tExcess weight\n" +
                        "•\tPrevious injury",

                "•\tObstructive sleep apnea\n" +
                        "•\tKidney problems\n" +
                        "•\tAdrenal gland tumors\n" +
                        "•\tThyroid problems\n" +
                        "•\tCertain defects you're born with (congenital) in blood vessels \n" +
                        "•\tCertain medications, such as birth control pills, cold remedies, decongestants, over-the-counter pain relievers and some prescription drugs\n" +
                        "•\tIllegal drugs, such as cocaine and amphetamines",

                "•\tHormonal fluctuation\n" +
                        "•\tExcess oil (sebum) production\n" +
                        "•\tHair follicles clogged by oil and dead skin cells\n" +
                        "•\tBacteria\n" +
                        "•\tInflammation\n" +
                        "•\tStress",

                "•\tImproper intake of fiber rich foods\n" +
                        "•\tInadequate intake of water and other fluids\n" +
                        "•\tIrregular habits of defection\n" +
                        "•\tExcess intake of dairy products\n" +
                        "•\tStress\n" +
                        "•\tEating disorder\n" +
                        "•\tLess physical activities\n" +
                        "•\tOver use of stool softeners or laxatives\n" +
                        "•\tHypothyroidisms\n" +
                        "•\tParkinson’s disease or multiple sclerosis\n" +
                        "•\tToo much intake of strong pain relievers or other drugs\n" +
                        "•\tPregnancy\n" +
                        "•\tColon cancer",

                "•\tHormonal change\n" +
                        "•\tMedication\n" +
                        "•\tStress\n" +
                        "•\tLoneliness/isolation\n" +
                        "•\tLack of social support\n" +
                        "•\tFamily history of depression\n" +
                        "•\tMarital or relationship problems\n" +
                        "•\tFinancial problems\n" +
                        "•\tAlcohol or drug abuse\n" +
                        "•\tUnemployment\n" +
                        "•\tHealth problems\n" +
                        "•\tStudies problems\n" +
                        "•\tBeauty problems"
        };



        // symptoms array data
        String[] symptomsData = {
                "•\tNausea\n" +
                        "•\tVomiting\n" +
                        "•\tDizziness\n" +
                        "•\tStroke\n" +
                        "•\tTenderness of the scalp\n" +
                        "•\tTightness sensation in the head\n" +
                        "•\tPain in your eyes when are looking into bright lights",

                "•\tHeadache\n" +
                        "•\tLoss of appetite\n" +
                        "•\tCold and cough\n" +
                        "•\tSore eyes\n" +
                        "•\tAching muscles and joints\n" +
                        "•\tRise in body temperature\n" +
                        "•\tFeeling of tiredness, weakness and dizziness\n" +
                        "•\tPalpitations (increasing heart beat)",

                "•\tSweating\n" +
                        "•\tChest pain\n" +
                        "•\tRunning nose\n" +
                        "•\tFracture in ribs\n" +
                        "•\tPain during respiration\n" +
                        "•\tItchiness in respiratory tract",

                "•\tSwollen, red tonsils\n" +
                        "•\tDifficulty swallowing\n" +
                        "•\tHoarse or muffled voice\n" +
                        "•\tPain or a sensation in the throat \n" +
                        "•\tWhite patches or pus on your tonsils\n" +
                        "•\tSore, swollen glands in your neck or jaw",

                "•\tFatigue\n" +
                        "•\tWeakness\n" +
                        "•\tHeadache\n" +
                        "•\tDry cough\n" +
                        "•\tLoss of appetite\n" +
                        "•\tNasal congestion\n" +
                        "•\tSweats and chills\n" +
                        "•\tVomiting and diarrhea in children\n" +
                        "•\tPains and aches in the muscle, partially the arms, legs and back\n" +
                        "•\tIn adults, a fever over 101 degrees Fahrenheit, or 38 degrees Celsius; in children, commonly as high as 103 -105 degrees Fahrenheit, or 39.0-40.5 degrees Celsius.",

                "•\tPain when chewing.\n" +
                        "•\tSwelling around the tooth\n" +
                        "•\tSensitivity to hot and cold food.\n" +
                        "•\tFeeling of pressure building up on the affected area.\n" +
                        "•\tBleeding from affected area and release of matter from the area.\n" +
                        "•\tExperiencing wisdom tooth pain when they are emerging.",

                "•\tNausea\n" +
                        "•\tBloating\n" +
                        "•\tTiredness\n" +
                        "•\tWatery diarrhea\n" +
                        "•\tStomach crumps\n" +
                        "•\tSoft, greasy stools\n" +
                        "•\tSevere weight loss",

                "•\tHeadache\n" +
                        "•\tVomiting or nausea\n" +
                        "•\tTears coming out of eyes \n" +
                        "•\tSensations of foreign body\n" +
                        "•\tCrusting of lashes or eyelids\n" +
                        "•\tDecease in the vision capacity\n" +
                        "•\tClear or thick and colored discharge",

                "•\tTearing\n" +
                        "•\tRedness\n" +
                        "•\tItchiness\n" +
                        "•\tA gritty feeling\n" +
                        "•\tA discharge that forms a crust during the night that may prevent your eye or eyes from opening in the morning",

                "•\tTension headache\n" +
                        "•\tAwakening too early\n" +
                        "•\tAwakening during the night\n" +
                        "•\tIncreased errors or accidents\n" +
                        "•\tOngoing worries about sleep\n" +
                        "•\tDifficulty falling asleep at night\n" +
                        "•\tIrritability, depression or anxiety\n" +
                        "•\tDay time tiredness or sleepiness",

                "•\tNausea\n" +
                        "•\tFatigue\n" +
                        "•\tDizziness\n" +
                        "•\tSweating\n" +
                        "•\tShortness of breath\n" +
                        "•\tChest pain or discomfort\n" +
                        "•\tPain in your arms, neck, jaw, shoulder or back accompanying chest pain",

                "•\tWeight loss\n" +
                        "•\tBlurry vision\n" +
                        "•\tExtreme hunger\n" +
                        "•\tExcessive thirst\n" +
                        "•\tFrequent urination\n" +
                        "•\tNausea and vomiting\n" +
                        "•\tSlow healing of wounds\n" +
                        "•\tElevated blood sugar level\n" +
                        "•\tLoss of glucose in the urine\n" +
                        "•\tNumbness in the hands or feet\n" +
                        "•\tLack of interest in the concentration",

                "•\tSevere, sharp pain in the side and back, below the ribs\n" +
                        "•\tPain that radiates to the lower abdomen and groin\n" +
                        "•\tPain that comes in waves and fluctuates in intensity\n" +
                        "•\tPain or burning sensation while urinating\n" +
                        "•\tPink, red or brown urine\n" +
                        "•\tCloudy or foul-smelling urine\n" +
                        "•\tA persistent need to urinate, urinating more often than usual or urinating in small amounts\n" +
                        "•\tNausea and vomiting\n" +
                        "•\tFever and chills if an infection is present",

                "•\tTickling or a sensation of something moving in the hair\n" +
                        "•\tIrritability and difficulty sleeping\n" +
                        "•\tSores on the head from scratching\n" +
                        "•\tSwollen lymph nodes, or glands\n" +
                        "•\tPink eye\n" +
                        "•\tThe most common symptom of a lice infestation is itching on the scalp, neck and ears.",

                "Burn symptoms vary depending on how deep the skin damage is. It can take a day or two for the signs and symptoms of a severe burn to develop.\n\n" +
                        "•\t1st-degree burn. This minor burn affects only the outer layer of the skin (epidermis). It may cause redness and pain.\n" +
                        "•\t2nd-degree burn. This type of burn affects both the epidermis and the second layer of skin (dermis). It may cause swelling and red, white or splotchy skin. Blisters may develop, and pain can be severe. Deep second-degree burns can cause scarring.\n" +
                        "•\t3rd-degree burn. This burn reaches to the fat layer beneath the skin. Burned areas may be black, brown or white. The skin may look leathery. Third-degree burns can destroy nerves, causing numbness.",

                "•\tSwelling and stiffness\n" +
                        "•\tRedness and warmth to the touch\n" +
                        "•\tWeakness or instability\n" +
                        "•\tPopping or crunching noises\n" +
                        "•\tInability to fully straighten the knee",

                "•\tHeadaches\n" +
                        "•\tShortness of breath\n" +
                        "•\tNosebleeds\n" +
                        "•\tFlushing\n" +
                        "•\tDizziness\n" +
                        "•\tChest pain\n" +
                        "•\tVisual changes\n" +
                        "•\tBlood in the urine",

                "•\tWhiteheads (closed plugged pores)\n" +
                        "•\tBlackheads (open plugged pores)\n" +
                        "•\tSmall red, tender bumps (papules)\n" +
                        "•\tPimples (pustules), which are papules with pus at their tips \n" +
                        "•\tLarge, solid, painful lumps under the skin (nodules)\n" +
                        "•\tPainful, pus-filled lumps under the skin (cystic lesions)",

                "•\tFew bowel movements\n" +
                        "•\tTrouble having a bowel movement (straining to go)\n" +
                        "•\tA sense that everything didn’t come out\n" +
                        "•\tBelly bloating\n" +
                        "•\tYou have fewer than three bowel movements a week.\n" +
                        "•\tYour stools are dry, hard and/or lumpy.\n" +
                        "•\tYour stools are difficult or painful to pass.\n" +
                        "•\tYou have a stomach ache or cramps.\n" +
                        "•\tYou feel bloated and nauseous.\n" +
                        "•\tHeart burn\n" +
                        "•\tVomiting\n" +
                        "•\tIntestinal pain",

                "•\tFeelings of sadness, tearfulness, emptiness or hopelessness\n" +
                        "•\tAngry outbursts, irritability or frustration, even over small matters\n" +
                        "•\tLoss of interest or pleasure in most or all normal activities, such as hobbies or sports\n" +
                        "•\tSleep disturbances, including insomnia or sleeping too much\n" +
                        "•\tTiredness and lack of energy, so even small tasks take extra effort\n" +
                        "•\tReduced appetite and weight loss or increased cravings for food and weight gain\n" +
                        "•\tAnxiety, agitation or restlessness\n" +
                        "•\tSlowed thinking, speaking or body movements\n" +
                        "•\tFeelings of worthlessness or guilt, fixating on past failures or self-blame\n" +
                        "•\tTrouble thinking, concentrating, making decisions and remembering things\n" +
                        "•\tFrequent or recurrent thoughts of death, suicidal thoughts, suicide attempts or suicide\n" +
                        "•\tUnexplained physical problems, such as back pain or headaches"
        };



        // Home Remedy array data
        String[] homeRemedyData = {
                "•\tIce pack: Applying an ice pack on your neck to get relief.\n" +
                        "•\tRosemary: dab a drop or two of thyme or rosemary essential oil on each temple and on your forehead. Rub gently into the skin, then sit quietly for several minutes. \n" +
                        "•\tCloves: Put two drops of cloves oil in a tablespoon of carrier oil and massage your forehead and temples with it.\n" +
                        "•\tApplying an ice pack on your neck to get relief.\n" +
                        "•\tPeel the small piece of ginger and extract two tablespoon of ginger. boil the ginger juice in water for 2 minutes, add little two table spoon lemon juice int it then uses it apply this process 3 to 4 times a day.",

                "•\tDrink tea made with from saffron.\n" +
                        "•\tA glass of milk also works wonders.\n" +
                        "•\tEat oranges. Oranges give instant energy and helps the body fight unwanted infections.\n" +
                        "•\tFruit teas. As a fever mounts, digestion slows. Avoid eating foods that are hard to digest. Instead drink mild, cooling fruit teas such as strawberry, raspberry vinegar, or rose petal tea.\n" +
                        "•\tPoplar bark. This should not be used to relieve fevers aches and pains in young children, as it contains the chemical precursor to aspirin and may cause complications. It may, however, be safely used by adults in combination with an emollient herb such as mallow or plantain.\n" +
                        "•\tBorage. A cup of strong, warm borage lemonade will cool a fever while stimulating the kidneys to flush poisons from the system. The high vitamin and mineral content will help the person regain strength. \n" +
                        "•\tEncourage sweating. Burdock, catnip, ginger, and peppermint encourage sweating, and may be used as teas or baths to help break moderate fevers.\n" +
                        "•\tTo bring down a fever, frequently sponge the patient's neck, forehead, ears, armpits, groin, and soles of feet with tepid brews of peppermint, catnip, or ginger. Have the patient drink as much water as possible, but in small frequent sips. Administer a teaspoon to a tablespoon of peppermint, catnip, or ginger tea every five minutes until the fever lowers.",

                "•\tBasil leaves and ginger are very effective in relieving an irritating dry cough. You can either chew basil leaves or take fresh ginger with hot water.\n" +
                        "•\tEat grapes. Grapes when eaten regularly can also help get rid of severe coughs.\n" +
                        "•\tDrinking a few cups of hot water with salt can also help stop coughing. \n" +
                        "•\tTake a hot shower. Breathing in the steam can provide temporary relief.\n" +
                        "•\tA jar of pine pitch is indispensable for these conditions use it as a steam pot to break up congestion, or mix it in a salve with peppermint so it can be rubbed on the chest or sore, aching muscles.",

                "•\tClove tea\n" +
                        "•\tGreen tea\n" +
                        "•\tSage and water\n" +
                        "•\tHot sauce and water\n" +
                        "•\tGinger, honey, and lemon in half boil water as a tea.\n" +
                        "•\tA mixture of Listerine mouth wash and Hydrogen Peroxide. Pour a little of each liquid into a cup (equal parts) and gargle.\n" +
                        "•\tEat three to four marshmallows to soothe a sore throat. The gelatin in the marshmallows is what soothes the sore throat.\n" +
                        "•\tNibble on fresh young borage leaf, dried or fresh mallow root, a small piece of poplar bark, or violet blossom. Or, if you are brave enough, chew a piece of fresh raw garlic for fast relief.\n" +
                        "•\tWhite pine. A strong infusion of white pine needle tea will coat the throat with its antiseptic resins and provide generous amounts of vitamins A and C. Or suck on homemade thyme and balsam poplar bud pastilles.",

                "•\tSimply take one table spoon of honey with a glass of water several times a day. You can also combine one teaspoon of honey with the juice extracted from 10 to 15 fresh basil leaves. Take this once a day. Note honey should not be given to children under one-year age.\n" +
                        "•\tSqueeze a lemon in a glass of warm water and drink it. Do these three or four times daily.\n" +
                        "•\tSimply chew one raw garlic clove pr swallow one teaspoon of garlic juice with water several times a day.\n" +
                        "•\tTurn on a hot shower and sit in the closed bathroom for a few minutes, inhaling the steam. Do this several times a day to ease congestion.\n" +
                        "•\tThe best prevention against viral infections is the resounding good health that comes from adding fresh herbs to your daily diet. Growing up in a medical family, and later working in a restaurant, I have been able to witness firsthand how easily germs are spread. Keeping your hands away from your eyes, nose, and mouth and washing them frequently will go a long way toward ensuring that the season's flu passes you by.\n" +
                        "•\tGarlic. Add 1 to 2 cloves of fresh raw garlic into your daily diet. Fresh garlic can be sprinkled on top of salads, soups, or bread, or mixed with honey, to minimize possible stomach upsets. \n" +
                        "•\tThyme. This herb has potent antiviral and antibiotic qualities. Start drinking thyme as your daily beverage when everyone around you is getting the flu. If it is too late and you are already ill, thyme tea will lessen the duration and severity of the illness.\n" +
                        "•\tRose hips. These are one of nature's best sources of vitamin C, and complement the flavor of nearly every herb you may choose to use to prevent colds and flus. Other herbs that are a good source of vitamins C or A are alfalfa, catnip, lemon balm, plantain, strawberry leaf, violet leaf, and white pine needle.\n" +
                        "•\tViolet. The common violet acts as a gentle immune-system stimulant. Drink a tea made from the whole aboveground portion of the plant. Other herbs that help stimulate the immune system to combat viral infections are St.-John's-wort, white pine, and strawberry leaf.\n" +
                        "•\tYogurt. Plain yogurt can kill bacteria all on its own, but it will also help your body gear up for production of antibodies to kill invading organisms.",

                "•\tGum tissue. To maintain healthy gums, while brushing your teeth, use a homemade toothbrush fashioned from the twig of the walnut, poplar, or rose. This will help tighten your gum tissues, reduce any inflammation, and have a mild antiseptic action. Simply sharpen one end of a pencil-length twig to use as a toothpick and chew on the fibers of the other end to use as a brush. Remove the thorns from the rose first by rubbing the twig lightly with a knife.\n" +
                        "•\tUse long rose or blackberry thorns as a field toothpick. Naturally grown thorns are sharper than toothpicks, they hold a point longer, and their curved shape makes them easier to\n" +
                        "•\tMouthwash. The simplest mouthwash of all is a fresh, aromatic, antiseptic lea chewed slowly. Lavender, lemon balm, peppermint, and thyme all excel as mouthwashes.\n" +
                        "•\tTooth whitener. Rub your teeth with a fresh strawberry to whiten them. Diluted strawberry and peppermint tincture makes an excellent antiseptic mouthwash.\n" +
                        "•\tTeething. Babies may get relief by chewing on a piece of fresh catnip or peppermint, or the freshly crushed leaf can be rubbed over the area.\n" +
                        "•\tAbscess. To relieve an abscessed tooth, rub the area with a fresh garlic clove cut in half, and eat 1 to 2 fresh cloves of garlic daily.\n" +
                        "•\tTooth decay. We all have heard the studies that link tooth decay to sweets. Less known, however, is that poor nutrition is also linked to tooth decay. A diet abundant in minerals gives you the building blocks necessary to maintain healthy, cavity-free teeth. Add liberal amounts of mineral-rich herbs such as alfalfa, burdock, dandelion, and violet to your diet to keep your smile free and easy.",

                "•\tPoplar bark. Though its antiseptic action is comparatively mild, poplar combines anti-inflammatory action and pain relief for a triple-power-packed punch. Poplar works best in herbal combinations such as poplar-plantain to heal bruises quickly, poplar-marshmallow for gastric inflammations, and poplar-garlic for inflamed bug bites and scrapes. \n" +
                        "•\tColic. Weak catnip tea is the surest remedy for infantile colic. It quiets the nervous system and eases gastric distress.\n" +
                        "•\tFirst of all leave of all food for at least 24 hours. Stick to bland light diet or liquids e.g. Khichri (porridge), Dal/rice, Fruit juices, Soups.\n" +
                        "•\tAvoid spicy food because that can irritate your stomach more. Have plenty of fluids like water but not milk - because it will increase the acid in stomach.\n" +
                        "•\tYou can apply hot water pads over the stomach every 3 hours.\n" +
                        "•\tTo prevent attacks,\n" +
                        "•\tEat slowly and chew properly.\n" +
                        "•\tEat regularly and avoid to eat in between the meals. Allow at least 5 hours in between meals.",

                "•\tRub your palms together briskly until they are quite warm. Now press your palms to your eyes for quick relief from eye strain, tiredness, and slight twitches.\n" +
                        "•\tCool compresses. Soothe hot, inflamed eyes by placing cool compresses of plantain, lemon balm, or rose water on them. Let rest for five minutes at a time. This also can be used to clean away excessive eye mucus from conjunctivitis or pink eye.\n" +
                        "•\tBorage. Borage leaf was much valued by the ancient Greeks for strengthening weak eyes and preventing cataracts. Recent studies show you are eleven times more likely to develop cataracts if your diet lacks in beta-carotene, folic acid, and vitamin C. Borage has plenty, as do many other dark leafy greens such as dandelion and violet.",

                "•\tCool compresses. Soothe hot, inflamed eyes by placing cool compresses of plantain, lemon balm, or rose water on them. Let rest for five minutes at a time. This also can be used to clean away excessive eye mucus from conjunctivitis or pink eye.\n" +
                        "•\tBlack tea is chock-full of astringent compounds called tannins that can help deflate and tighten the bags under your eyes. (Not to mention black tea is associated with a lower risk of type 2 diabetes.) Activate the tannins in a tea bag by dipping in a cup of hot water for several minutes. Cool in the fridge, then apply the damp bag as a compress to the closed eye for 10 minutes.\n" +
                        "                                                                                      [Experts Name: Ronald Hoffman, MD]\n" +
                        "•\t Regularly place a cool compress over the eyes, made by soaking clean cotton wool or cloth in warm or cold water and then squeezing it out.\n" +
                        "•\tAvoid eye makeup, or choose hypoallergenic eye make up.\n" +
                        "•\tUse artificial tears, which are available for purchase online or over-the-counter or from pharmacies.",

                "•\tSleep on a pillow filled with dried lavender blossom, rose petal, and catnip to ease restlessness and insomnia. Children love to make these pillows, and it is a good way to introduce them to herbalism.\n" +
                        "•\tThink of oats as a one-penny moisturizer. Tie a handful of rolled oats in a muslin bag. Moisten the bag and rub it on chapped skin, mild sunburn, eczema, insect bites, and itchy rashes or toss it into a warm bath. This same soluble gummy fiber soothes the intestinal tract and lowers cholesterol. Eat oat porridge during convalescence to rebuild strength. Both the grain and the oat straw nourish nerve cells and help the body cope with insomnia, anxiety, and nerve disorders such as shingles.\n" +
                        "•\tBefore bedtime, eat a handful of cherries (or drink tart cherry juice), which scientists discovered are jam-packed with melatonin, the same hormone created by your body to regulate sleep patterns. Then steep yourself in a hot bath to relax your muscles and your mind. In bed, rest your head on a lavender-filled pillow—the fragrance induces sleepiness. (Bonus: Cherries can help prevent gout attacks.)\n" +
                        "[Experts Name: La Puma]",

                "•\tWines seem to be slightly more beneficial than white. Homemade wines with herbs that enhance circulation, such as red clover, will add an extra benefit. However, even moderate alcohol consumption may bring on chest pain if you have angina, and those who drink more than a glass a day are putting themselves at risk for other health problems.",

                "•\tKeep your blood sugar at a target level (which you set with your doctor).\n" +
                        "•\tEat a good diet that spreads carbohydrate throughout the day. Carbohydrate-the body's main source of fuel-affects blood sugar more than any other nutrient. Carbohydrate is in fruits, vegetables, milk, and yogurt. It also is in breads, cereals, vegetables such as potatoes and corn, and sugary foods such as candy and cakes.\n" +
                        "•\tAim for at least 2½ hours of exercise a week. Walking is a good choice. You also may want to do other activities, such as running, swimming, cycling, or playing tennis or team sports. If your doctor says it's okay, do muscle-strengthening exercises 2 times a week and aim for 3 times a week.\n" +
                        "•\tTake your medicines exactly as prescribed. Call your doctor or nurse call line if you think you are having a problem with your medicine. You will get more details on the specific medicines your doctor prescribes.\n" +
                        "•\tCheck your blood sugar as often as your doctor recommends. It is important to keep track of any symptoms you have, such as low blood sugar, and any changes in your activities, diet, or insulin use.\n" +
                        "•\tTalk to your doctor before you start taking aspirin every day. Aspirin can help certain people lower their risk of a heart attack or stroke. But taking aspirin isn't right for everyone, because it can cause serious bleeding.",

                "•\tYogurt. Eating a cup of yogurt daily to prevent yeast and bladder infections may sound like an old wives' tale, but it really works. The culture must be live to have any effect. For extra relief, add a cup of yogurt to a warm bath, or douche with a tablespoon of yogurt mixed in a quart of warm water.\n" +
                        "•\tBurdock and dandelion. Both of these herbs gently stimulate the kidneys to increase the flow of urine, yet have enough.\n" +
                        "•\tVitamins and minerals to replace any that may then be excreted in the urine. Thus they are generally considered safe for long-term use. Dandelion has a greater capacity for clearing obstructions from the kidneys and bladder, while burdock eases the strain on the kidneys by promoting sweat and encouraging the skin to eliminate toxins as well.\n" +
                        "•\tBladder infections. These are the second most common complaint (next to menstrual difficulties) of women. Frequently they coincide with ovulation or pregnancy. Underwear traps bacteria and moisture and creates an ideal breeding ground. Wear none, or wear loose-fitting cotton underwear that breathes, if you are prone to infection. Also, drink copious amounts of water to dilute bacteria concentrations and increase urination; this helps the body rid itself of the bacteria. Avoid caffeine, as it irritates the kidneys; mild diuretics such as dandelion or burdock root help, though. Drinking 1/2 to 2 cups of cranberry or blueberry juice incapacitates the E. coli bacteria responsible for causing the infection. Drink 1/2 cup daily as a preventative or increase to 2 cups daily to help combat a current infection.\n" +
                        "•\tA tea made from equal parts of mallow root, dandelion root, and plantain leaf will relieve kidney and bladder infections. Plantain, especially, helps the kidneys secrete uric acid and is therefore helpful in attacks of gout.\n" +
                        "•\tWhenever administering an herb to increase the flow of urine, I add a demulcent herb such as mallow to help soothe any irritated tissue and to ease the possible passage of stones.\n" +
                        "•\tSluggish kidneys. Compresses of warm ginger applied to the abdomen help stimulate sluggish kidneys, without necessarily increasing urine output.\n" +
                        "•\tKidney stones. Drinking daily infusions of rose hip tea has been demonstrated to be useful in preventing and breaking up kidney stone.",

                "•\tPlantain seeds are an excellent source of easily assimilated B vitamins, and I have met several people who swear they owe their abundant dark hair (and the fact that lice, ticks, and mosquitoes leave them alone) to sprinkling crushed plantain seeds on each meal.\n" +
                        "•\tPlace these items in a sealed bag for two weeks. To kill lice and nits, machine wash all washable clothing and bed linens used by the infested person(s) during the two days before treatment. Use the hot water (130ºF) cycle during the washing process. Dry laundry using high heat for 20 minutes.",

                "•\tDo not try to treat third-degree burns, burns over a large area of the body, or chemical or electrical burns at home. Instead, stabilize the person, monitor for shock, and arrange transport or emergency medical treatment immediately. I have, however, treated severe second-degree burns when necessity demanded it.\n" +
                        "•\tFirst, assess the situation and remove the person from any further danger. If it is a chemical burn, keep flushing the skin with cold running water until well after the pain has stopped. Keep foremost in mind the importance of not damaging the skin any further, and keep the burn as clean as possible. Clean the area of any debris or dirt very gently do not break any skin or blistered areas. For first- and mild second-degree burns, immediately place the area in cold water to ease the pain, as long as the skin is not broken.\n" +
                        "•\tSalve. A combination of St.-John's-wort and poplar made into a salve with vitamin E (rose hip seeds are a good source) will add the dimension of pain and inflammation relief and nerve fiber rejuvenation to a remedy. Smear the area liberally with the salve. Bandage, changing the dressing two or three times a day until signs of healing are obvious. New skin may grow back fused together, so wrap digits individually. Monitor for any signs of infection, and seek treatment if the area shows any signs of worsening.",

                "•\tRest your knee so it can heal. Limit activities that increase your pain.\n" +
                        "•\tApply ice to help reduce swelling and pain\n" +
                        "•\tApply compression to help reduce swelling \n" +
                        "•\tElevate your knee to help decrease pain and swelling \n" +
                        "•\tPrevent your knee from moving",

                "•\tOrthodox medicine acknowledges that garlic reduces cholesterol, lowers blood pressure, and decreases the risk of heart attack.\n" +
                        "•\tTo begin blood pressure measurement, use a properly sized blood pressure cuff.\n" +
                        "•\tWrap the cuff around the upper arm with the cuff's lower edge one inch above the antecubital fossa.\n" +
                        "•\tLightly press the stethoscope's bell over the brachial artery just below the cuff's edge.\n" +
                        "•\tRapidly inflate the cuff to 180mmHg.",

                "•\tGently wash your face 1 or 2 times a day with warm (not hot) water and a mild soap or cleanser. Always rinse well.\n" +
                        "•\tUse an over-the-counter lotion or gel that contains benzoyl peroxide. Start with a small amount of 2.5% benzoyl peroxide and increase the strength as needed. Benzoyl peroxide works well for acne, but you may need to use it for up to 2 months before your acne starts to improve.\n" +
                        "•\tApply acne cream, lotion, or gel to all the places you get pimples, blackheads, or whiteheads, not just where you have them now. Follow the instructions carefully. If your skin gets too dry and scaly or red and sore, reduce the amount. For the best results, apply medicines as directed. Try not to miss doses.\n" +
                        "•\tDo not squeeze or pick pimples and blackheads. This can cause infection and scarring.\n" +
                        "•\tUse only oil-free makeup, sunscreen, and other skin care products that will not clog your pores.\n" +
                        "•\tWash your hair every day, and try to keep it off your face and shoulders. Consider pinning it back or cutting it short.\n" +
                        "•\tTry hair care products and styling techniques. Hair care products or perms may make hair appear thicker. You can use dyes to color the scalp. But long-term use of perms or dyes may lead to more hair loss.\n" +
                        "•\tTalk to your doctor if you are very upset about your hair loss. You can get counseling to help you cope with the condition.",

                "•\tConstipation is usually caused by not eating enough fruits, vegetables, or foods with natural fiber, or by lack of exercise. The safest remedy may be as simple as drinking several glasses of water and enjoying a walk.\n" +
                        "•\tStrawberry. This fruit has a mild laxative effect, and is especially useful when the constipation is due to excessive meats or fats in the diet.\n" +
                        "•\tMullein. Mullein tea made with milk will help a person pass hard stools easier because of its demulcent and emollient properties.\n" +
                        "•\tGreens. Intensely green leaves are slightly laxative to many people. Add servings of fresh or steamed violet leaf, dandelion greens, or plantain leaf to the diet. This has the added benefit of replacing possible lost nutrients.\n" +
                        "•\tHoney. This also has a slight laxative effect. \n" +
                        "•\tPlantain. Pour a cup of boiling water over 1 tablespoon of coarsely ground plantain seeds. Let sit for 20 minutes and drink, without straining, just before bedtime. This is an excellent laxative for more persistent constipation, or constipation from pregnancy, iron supplements, or prescribed medication. The seeds replace valuable B vitamins, soothe the entire digestive tract, and have no known harmful chemical or drug interactions. Do not use, however, if you have diverticulosis, as the seeds may cause irritation.",

                "•\tSt.-John's-wort and lemon balm have the additional benefit of easing the depression that invariably accompanies long-term illness."
        };



        // Tib e Nabvi array data
        String[] tibeNabviData = {
                "1.\tHazrat Salma Umme Rafe ـ said that Rasool Ullah advised wet cupping Hijamah for headache (migraine) & Heena for leg pain.       \n" +
                        "                                                                                                  [Abu Dawud: 3858; Book. 29; English Book. 28; Hadees. 3849]\n" +
                        "\n" +
                        "2.\tNarrated by Ibn Ma-jah that whenever Prophet Muhammad suffered from a headache, He used to cover His Head with Henna (Khazaab) & said: \"Henna helps to relieve headache by the permission of Allah \uF049 \".    \n" +
                        "                                                                                       [Ibn Ma-jah: 3502 & Abu Dawud: 3823 according to Maktabah Shamilah]\n" +
                        "\n" +
                        "3.\tIn addition, Sahih Hadees states that Nabi PBUH said during the illness, that precede to leave this world: \"Oh My Head\". He PBUH used to tie a piece of cloth around His Head. Tying a piece of cloth around the head helps soothe the pain of headaches & migraines.       \n" +
                        "                                                                                                                                                   [Al-Tibb Al-Nabawi of Abu Nu-aim: 69]\n" +
                        "\n" +
                        "4.\tNarrated by Ibn Ma-jah that whenever Prophet Muhammad suffered from a headache, He used to cover His Head with Henna (Khazaab) & said: \"Henna helps to relieve headache by the permission of Allah \uF049 \".\n" +
                        "                                                                                               [Ibn Ma-jah: 3502 & Abu Dawud: 3823 according to Maktabah Shamilah]\n",

                "1.\tNarrated by A’isha that Nabi PBUH said: \"Fever is from the heat of the (Hell) Fire, so cool it with water.\" \n" +
                        "                                                                                                         [Bukhari: 3263; Book. 59; English vol. 4; Book. 54; Hadees. 485]\n" +
                        "\n" +
                        "2.\tNarrated from Abu Hurairah that Nabi said: “Fever is one of the bellows of Hell, so avert it from you with cold water.” \n" +
                        "                                                                                    [Ibn Ma-jah: 3604; Book. 31; English vol. 4; Book. 31, Hadees. 3475]\n" +
                        "\n" +
                        "3.\tNarrated by Rafe’ Bin Khadij that Nabi   said: “Fever is from the agitation of fire, so cool it with water”.\n" +
                        "                                                                                   [ Tirmizi: 2216; Book. 28; English vol. 4; Book. 2, Hadees. 2072]\n" +
                        "4.\tNarrated by Abu Jamra PBUH that he used to sit with Ibn Abbas in Makkah, once I had a fever & he said (to me): \"Cool your fever with Zamzam water, Nabi said: 'It, (the Fever) is from the heat of the (Hell) Fire; so, cool it with water (or Zamzam water).\n" +
                        "                                                                                                          [Bukhari: 3261; Book. 59; English vol. 4; Book. 54; Hadees. 483]\n",

                "1.\tHazrat Anas says that Nabi PBUH said: “For you Marzanjosh is present, this is very beneficial in cold & cough it can be smelled (its steam).\n" +
                        "                                                                                                                             [Kanz al-Ummal: 17345 & Abu Nu-aim: 286]\n" +
                        "2.\tNarrated by Abdullah Bin Sa’ib that Nabi PBUM recited Surah AlMu’minun in the Fajar prayer & when He PBUH came to offer Eisha (prayer), He PBUH was overcome with a cough, so He PBUH bowed in Ruku. \n" +
                        "                                                                                                                    [Ibn Ma-jah: 869; Book. 5; English vol. 1; Book. 5, Hadees. 820]\n",

                "1.\tHazrat Anas Bin Malik   says that Rasoolullah PBUH said: “To your children during Azrah (their throat infection), do not press their throat & do not give them Azaab (Pain) you have Costus (Qust) use it.\n" +
                        "                                                                                                       [Bukhari: 5696; Book. 76; English vol. 7; Book. 71; Hadees. 599]\n" +
                        "\n" +
                        "2.\tNarrated by Umme Qais Bint Minsaan that she took her son to Nabi PBUH who was suffering from Azrah (throat infection) & she had pressed his throat part, Nabi PBUH saw the child & said: “Why do you press your children & you should use Al-Ud hind (Aloes wood) for it, there are 7 cures, it should be inhaled for Azrah & taken by mouth for Zaatul Janb (pleurisy). \n" +
                        "                                                                                                                   [Ibn Ma-jah: 3590; Book. 31; English vol. 4; Book. 31, Hadees. 3462]\n",

                "1.\tEarly research shows that taking 2 drops of marjoram oil daily along with asthma medication for 3 months might improve lung function in people with asthma better than taking asthma medication alone. Its oil is also used for coughs, gall bladder complaints, stomach cramps & digestive disorders, depression, dizziness, migraine, nervous headaches, nerve pain, paralysis, coughs, running nose; & as a water pill.\n" +
                        "                                                                                               [Tibb-e-Nabawi PBUH by Dr. Mohammed Shakeel Shamsi]\n",

                "1.\tIn addition, in the Sahihain, it is also narrated that: “Whenever Prophet Muhammad Sallallaho Alaihe Wasallam would wake up at night, he would clean his mouth with Siwaak”.\n" +
                        "                                                                                                                                                                       [Sahih Muslim]\n" +
                        "\n" +
                        "2.\tBukhari narrated that Prophet Muhammad Sallallaho Alaihe Wasallam said: “Siwaak cleanses the mouth and pleasures the LORD (Allah)”.\n" +
                        "                                                                                                                                                                               [Bukhari]\n" +
                        "\n" +
                        "3.\tSahih Muslim narrated that whenever Prophet Muhammad Sallallaho Alaihe Wasallam would enter his house, he would first use the Siwaak”.\n" +
                        "                                                                                                                                                                  [Sahih Muslim]\n",

                "1.\tNarrated by Umme Salma that Nabi PBUH said: \"He who drinks in silver utensils is only filling his Abdomen with Hell Fire.\"\n" +
                        "                                                                                                                  [Bukhari: 5634; Book. 74; English vol. 7; Book. 69; Hadees. 538]\n" +
                        "2.\tIt is reported on the authority of Malik Bin Sa'sa' that Nabi \uF065 said that (for Me) was brought a gold basin full of wisdom & faith & then the (part of the body) right from the upper end of the chest to the lower part of the abdomen was opened & it was washed with the water of Zamzam & then filled with wisdom & faith. \n" +
                        "                                                                                                [Muslim: 164 B; Book. 1; English Book. 1; Hadees. 315]\n" +
                        "3.\tNarrated by Abu Hurairah \uF074 that once Nabi PBUH set out early morning, also I did, & I prayed & sat, to this Nabi PBUH turned & asked, do you have a stomach problem? I answered yes, to this Nabi PBUH said: “Get up & pray (salah), for in Salah there is Shifa (cure). \n" +
                        "[Ibn Ma-jah: 3585; Book. 31; English vol. 4; Book. 31, Hadees. 3458]\n",

                "1.\tHazrat Nubayh Ibn Wahb says that Hazrat Umer ibn Udaidullah ibn Ma’mar had an eye infection & he wanted to apply collyrium (Surma) (kohl) in his eye, but Hazrat Abaan ibn Usman told him not to do so, & asked to apply Sabir (aloe vera) in his eye, & said that he heard from Hazrat Usman ibn Affan that, Nabi PBUH did the same. \n" +
                        "                                                                                [Abu Dawud: 1838; Book. 11; English Book. 10; Hadees. 1834]\n" +
                        "2.\tHazrat Suhaib reports that his right eye was paining & he was eating Tamar (dates), looking to this; Rasoolullah PBUH said that you are eating Tamar (dates) in spite of eye pain, on this, Hazrat Suhaib said, that I am eating from left side & my right eye is paining.\n" +
                        "                                                                                                                                                                 [Baihaqi: 20047]\n" +
                        "3.\tHazrat Abdullah Bin Abbas says that Rasoolullah \uF065 said: The best surma you have is Ismid (Antimony) it makes the vision clear & makes the hair (eye lashes) grow.\n" +
                        "                                                                          [Ibn Ma-jah: 3626; Book. 31; English vol. 4; Book. 31, Hadees. 3497]\n",

                "1.\tWhenever any of the Nabi PBUH's wives suffered from conjunctivitis, Nabi PBUH did not touch her until her eyes were cured\". \n" +
                        "                                                                                                                                                          [Reference Abu Nu-aim; at-Tibbun Nabawi]\n" +
                        "2.\tHazrat Abu Saeed & Jabir says that Nabi PBUH said that Kamaat (are a type of Mann & its water is a healing for eyes (diseases) & the `Ajwah (dates) are from Paradise (Jannah) & they are healing for poisoning. Kamaat (truffle / mushroom) a blessing thing & cure for eye diseases\n" +
                        "                                                                                                                    [Ibn Ma-jah: 3579; Book. 31; English vol. 4; Book. 31, Hadees. 3453]\n",

                "1.\tSulaiman Bin Buraidah PBUH narrated that his father said that Khalid Bin Waleed complained to Nabi PBUH: ‘O Rasoolullah PBUH! I do not sleep at night due to insomnia.’ So, Nabi PBUH replied: When you go to your bed, recite (Talawat).\n" +
                        "                                                                                                                               [Tirmizi: 3523; Book. 48, English vol. 6; Book. 45, Hadees. 3523]\n" +
                        "2.\tOne should not sleep immediately after eating & do some zikr or offer Salah is best. \n" +
                        "                                                                                                                                                        [Shamail-e-Kubra; vol. 1; page. 94]\n",

                "1.\tHazrat Talha says that he went to Nabi PBUH & Nabi PBUH had Safarjal in His Hand & said, take it, Oh! Talha for it soothes the heart. \n" +
                        "                                                                                                                          [Ibn Ma-jah: 3494: Book. 29; English vol. 4; Book. 29, Hadees. 3369]\n" +
                        "2.\tHazrat Jabir Bin Abdullah PBUH says that Nabi PBUH said: \"Eat Safarjal (Quince) because it heals cardiac problems & removes heaviness from chest.\n" +
                        "                                                                                                                                 [Kanzal-Ummal: 28258]\n",

                "1.\tMany scholars & Aaleems has seen in their dreams, that they complaint about their diabetes (in their dreams) to Nabi PBUH & He PBUH advised to put Rose water (2 to 3 spoon) in 1 glass of water & drink it early morning empty stomach, the scholars say that they started the rose water as mentioned & their diabetes got cured fully.\n" +
                        "                                                                                                                [Tibb-e-Nabawi PBUH by Dr. Mohammed Shakeel Shamsi]\n",

                "1.\tHazrat A’isha ـ says that Rasoolullah PBUH said that “There is an important part of kidney (called as) khasaura when this part gets swelled up, the person gets great pain & problems, treat this with excessively boiled water (muharraq) & Honey).\n" +
                        "                                                                                                                                                                  [Mustadrak Al Hakim: 8237; Al-Tibb]\n",

                "1.\tNarrated by Anas that Abdur Rahman Bin Auf & Zubair complained to Nabi PBUH about the lice (that caused itching) so He PBUH allowed them to wear silken clothes. I saw them wearing such clothes in a holy battle. \n" +
                        "                                                                                                                        [Bukhari: 2920; Book. 56; English vol. 4; Book. 52; Hadees. 169]\n",

                "1.\tHoney is useful agent against common burns.\n" +
                        "                                                            [Al Quran]\n",

                "1.\tNarrated by A’isha that When Nabi PBUH suffered from some pain, He PBUH recited Mu’auwwadhat (Surah Falaq & Surah Naas) in His Heart & blew (them over Him). When the pain became severe, I recited (them) over Him & wiped Him with His Hand in the hope of its blessing.\n" +
                        "                                                                                                                                  [Abu Dawud: 3902; Book. 29; English Book. 28; Hadees. 3893]\n" +
                        "2.\tA'isha reported that when Nabi PBUH missed the night prayer due to pain or any other reason, He PBUH (use to) observed twelve rak'ah during the daytime. \n" +
                        "                                                                                                          [Muslim: 746 E; Book. 6; English Book. 4; Hadees. 1627]\n",

                "1.\t\"Let fall these black seeds (kalonji) upon you, these contain cure for all diseases except death.\" \n" +
                        "                                                                                                                                                                        [Sahih Bukhari- 592]\n" +
                        "2.\t“Honey is the remedy for every illness and Quran is the remedy for all illness of mind, therefore I recommended to you both remedies, the Quran and the Honey” \n" +
                        "                                                                                                                                                               [Sunaan Tirmidhi: 1196]\n",

                "1.\tHazrat Umme Salma رضي الله عنها says that “When Abu Salma died, I had applied Sabir (Aloe Vera) on my eyes, and Rasool Allah صلی اللہ علیہ وسلم came & asked her “What is this, Umme Salma”?  Hazrat Umme Salma رضي الله عنها answered, “It is Sabir (صبر), it has no perfume in it, Rasool Allah صلی اللہ علیہ وسلم answered that “It makes the face Brighter, but do not use it expect Nights & remove it in day time, & do not apply perfume when combing your hairs, or Heena, because it is dye, Then Hazrat Umme Salma رضي الله عنها asked What should I use while combing my hairs oh! Rasool Allah صلی اللہ علیہ وسلم?  Rasool Allah صلی اللہ علیہ وسلم replied “Use Lotus leaves, to cover your head”\n" +
                        "                                                                             [Reference Abu Dawud: 2305; Book no. 13; In English Book no. 12; Hadees no. 2298.]\n" +
                        "\n" +
                        "2.\tHoney is extremely nourishing for the skin when used as face pack and helps in rejuvenating the skin leading to the elimination of fine wrinkles. It is a good moisturizer. The Prophet (PBUH) said: “Honey is the remedy for every illness and Quran is the remedy for all illness of mind, therefore I recommended to you both remedies, the Quran and the Honey” \n" +
                        "                                                                                                                                                                    [Sunaan Tirmidhi: 1196]\n",

                "1.\tHazrat Asma Bint Umair   says that Rasoolullah PBUH asked her: “What do you use as a laxative she replied \"Shabram\" (spruge). Rasoolullah PBUH said it is hot & powerful.  she said: Then I used Sanna (senna) as a laxative & (she said that Rasoolullah PBUH said: \"If there would be cure for death it would be Sanna (Senna). \n" +
                        "                                                                                                                         [Tirmizi: 2225; Book. 28; English vol. 4; Book. 2, Hadees. 2081]\n" +
                        "2.\tHazrat Ibn Abbas says that Rasoolullah PBUH said: \"Amongst the treatment you do, the best is:\n" +
                        "•\tto put medicine in one side of mouth \n" +
                        "•\tput medicine in nose\n" +
                        "•\tHijamah (wet cupping)\n" +
                        "•\tWalking (laxatives) \n" +
                        "                                                                                 [Tirmizi: 2184; Book. 28, English vol. 4; Book. 2, Hadees. 2047]\n",

                "1.\tAbu Sa'eed Al-Khudri narrated that Nabi PBUH said: Nothing afflicts the believer, whether fatigue, grief, disease - even a worry that concerns him - except that by it, Allah \uF049 removes something from his bad deeds. \n" +
                        "                                                                                                                 [Tirmizi: 966; Book. 10, English vol.2; Book. 5, Hadees. 966]\n" +
                        "2.\tHazrat A’isha says that whenever in our family anyone passed away (die), people use to come to meet (for pursa) specially ladies, when all the people use to go away, expect close family members than Hazrat A’isha ـ use to ask to cook Talbinah then ask to cook Sareed than she uses to ask to put Talbinah in Sareed vessel & ask to eat & she use to say that she heard Nabi PBUH saying that Talbinah brings comfort to the & lessens grief.                                   \n" +
                        "                                                                                                         [Muslim: 2216; Book. 39; English Book. 26; Hadees. 5491]\n"

                };



        // set Array data into the TextViews according to Intent position
        introText.setText(introData[positionDiseases]);
        causesText.setText(causesData[positionDiseases]);
        symptomsText.setText(symptomsData[positionDiseases]);
        homeRemedyText.setText(homeRemedyData[positionDiseases]);
        tibeNabviText.setText(tibeNabviData[positionDiseases]);


    }
}