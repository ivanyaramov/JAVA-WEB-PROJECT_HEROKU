package com.example.project.service.impl;

import com.example.project.model.entity.Town;
import com.example.project.model.view.CountryViewModel;
import com.example.project.model.view.LandmarkViewModel;
import com.example.project.model.view.TownViewModel;
import com.example.project.repository.TownRepository;
import com.example.project.service.CountryService;
import com.example.project.service.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final CountryService countryService;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, CountryService countryService, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.countryService = countryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initialiseTowns() {
        if (townRepository.count()==0){
            Town sofia = new Town("Sofia","Sofia is the capital and largest city of Bulgaria. It is situated in the Sofia Valley at the foot of the Vitosha mountain in the western parts of the country. The city is built west of the Iskar river, and has many mineral springs, such as the Sofia Central Mineral Baths.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635883675/366ce1486875fb28be1e9975e86361ba_iertgi.jpg");
            sofia.setCountry(countryService.findByName("Bulgaria"));
            townRepository.save(sofia);
            Town belgrade = new Town("Belgrade","The capital of Serbia, Belgrade, is known as “the city that never sleeps”. ... And yet, Belgrade is one of the oldest cities in Europe. This “white city” is the only capital built at the confluence of two big rivers – the Danube and the Sava. Belgrade is a modern european city with population of about 1.7 million people.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635883528/Sofia-2_a19v4j.jpg");
            belgrade.setCountry(countryService.findByName("Serbia"));
            townRepository.save(belgrade);
            Town dubrovnik = new Town("Dubrovnik","Dubrovnik, Italian Ragusa, port of Dalmatia, southeastern Croatia. Situated on the southern Adriatic Sea coast, it is usually regarded as the most picturesque city on the Dalmatian coast and is referred to as the “Pearl of the Adriatic.” ... The old city of Dubrovnik was designated a UNESCO World Heritage site in 1979.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635880953/download_4_crcffg.jpg");
            dubrovnik.setCountry(countryService.findByName("Croatia"));
            townRepository.save(dubrovnik);
            Town zagreb = new Town("Zagreb","Zagreb is the most important transport hub in Croatia where Central Europe, the Mediterranean and Southeast Europe meet, making the Zagreb area the centre of the road, rail and air networks of Croatia. It is a city known for its diverse economy, high quality of living, museums, sporting, and entertainment events.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635880995/download_5_pcfnlm.jpg");
            zagreb.setCountry(countryService.findByName("Croatia"));
            townRepository.save(zagreb);
            Town ljubljana = new Town("Ljubljana","Ljubljana is the political and cultural heart of the Slovenian nation. It is an important European commercial, business, exhibition and congressional centre as well as the transport, science and education centre of Slovenia.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881047/Ljubljana_gywq9x.jpg");
            ljubljana.setCountry(countryService.findByName("Slovenia"));
            townRepository.save(ljubljana);
            Town rome = new Town("Rome","Rome (Italian: Roma), the Eternal City, is the capital and largest city of Italy and of the Lazio region. It is famous for being the home of the ancient Roman Empire, the Seven Hills, La Dolce Vita (the sweet life), the Vatican City and Three Coins in the Fountain.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881091/download_6_i3bkvx.jpg");
            rome.setCountry(countryService.findByName("Italy"));
            townRepository.save(rome);
            Town florentia = new Town("Florentia","Florence, Italian Firenze, Latin Florentia, city, capital of Firenze provincia (province) and Toscana (Tuscany) regione (region), central Italy. The city, located about 145 miles (230 km) northwest of Rome, is surrounded by gently rolling hills that are covered with villas and farms, vineyards, and orchards.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881162/download_7_yw70q6.jpg");
            florentia.setCountry(countryService.findByName("Italy"));
            townRepository.save(florentia);
            Town milano = new Town("Milano","Milan, Italian Milano, city, capital of Milano province (provincia) and of the region (regione) of Lombardy (Lombardia), northern Italy. It is the leading financial centre and the most prosperous manufacturing and commercial city of Italy. Shoppers in the Galleria Vittorio Emanuele II, Milan.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881230/download_8_yywhnl.jpg");
            milano.setCountry(countryService.findByName("Italy"));
            townRepository.save(milano);
            Town sanmarino = new Town("San Marino","Located on the northeastern side of the Apennine Mountains, San Marino covers a land area of just over 61 km2 (24 sq mi), and has a population of 33,562. ... The country's capital city, the City of San Marino, is located atop Mount Titan, while its largest settlement is Dogana within the largest municipality of Serravalle.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635883422/c2bcd3c638c9edcd2208266e5f009e4702b6dc9e54dcc56d04afd01e8dff3da8_ka9qas.jpg");
            sanmarino.setCountry(countryService.findByName("San Marino"));
            townRepository.save(sanmarino);
            Town vatican = new Town("Vatican","Vatican City (Città del Vaticano in Italian) is an independent city state located in the heart of Rome, ruled by the Pope (Bishop of Rome). It is the centre of authority over the Roman Catholic Church. ... In this small state lives the Pope, in the Apostolic palace surrounded by beautiful gardens.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881427/download_10_bax4lc.jpg");
            vatican.setCountry(countryService.findByName("Vatican"));
            townRepository.save(vatican);
            Town budapest = new Town("Budapest","Budapest, city, capital of Hungary, and seat of Pest megye (county). The city is the political, administrative, industrial, and commercial centre of Hungary. The site has been continuously settled since prehistoric times and is now the home of about one-fifth of the country's population.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881474/download_11_oimpnj.jpg");
            budapest.setCountry(countryService.findByName("Hungary"));
            townRepository.save(budapest);
            Town vienna = new Town("Vienna","Vienna, also described as Europe's cultural capital, is a metropolis with unique charm, vibrancy and flair. ... Facts: Vienna, the capital of Austria, 2 million inhabitants, is situated on the banks of the Danube.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881534/download_12_xjmnue.jpg");
            vienna.setCountry(countryService.findByName("Austria"));
            townRepository.save(vienna);
            Town innsbruck = new Town("Innsbruck","Innsbruck, Austria. The old town has narrow streets lined with medieval houses and arcades. ... Innsbruck is one of the most popular tourist and health resorts and winter-sports centres in central Europe. The Olympic Winter Games were held there in 1964 and 1976.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881563/download_13_mfcmm2.jpg");
            innsbruck.setCountry(countryService.findByName("Austria"));
            townRepository.save(innsbruck);
            Town munich = new Town("Munich","It is Bavaria's largest city and the third largest city in Germany (after Berlin and Hamburg). Munich, by far the largest city in southern Germany, lies about 30 miles (50 km) north of the edge of the Alps and along the Isar River, which flows through the middle of the city. Pop.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881622/download_14_fz14fg.jpg");
            munich.setCountry(countryService.findByName("Germany"));
            townRepository.save(munich);
            Town frankfurt = new Town("Frankfurt","Frankfurt is the largest financial centre in continental Europe. ... Its central location within Germany and Europe makes Frankfurt a major air, rail and road transport hub. Frankfurt Airport is one of the world's busiest international airports by passenger traffic and the main hub for Germany's flag carrier Lufthansa.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881662/download_15_ci50rx.jpg");
            frankfurt.setCountry(countryService.findByName("Germany"));
            townRepository.save(frankfurt);
            Town stuttgart = new Town("Stuttgart","Stuttgart, city, capital of Baden-Württemberg Land (state), southwestern Germany. Astride the Neckar River, in a forested vineyard-and-orchard setting in historic Swabia, Stuttgart lies between the Black Forest to the west and the Swabian Alp to the south.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881722/download_16_bwwakx.jpg");
            stuttgart.setCountry(countryService.findByName("Germany"));
            townRepository.save(stuttgart);
            Town rust = new Town("Rust","Rust is a small commune in the southwest of Germany. This small town is located in Baden-Württemberg. It became famous with the opening of the Europa-Park theme park in 1975. It is the second-largest amusement park on the European continent by a number of visitors.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881762/download_17_rfdkxo.jpg");
            rust.setCountry(countryService.findByName("Germany"));
            townRepository.save(rust);
            Town paris = new Town("Paris","Paris (nicknamed the \"City of light\") is the capital city of France, and the largest city in France. ... Paris is also the center of French economy, politics, traffic and culture. Paris has many art museums and historical buildings. As a traffic center, Paris has a very good underground subway system (called the Metro).",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881816/download_18_tuq6pl.jpg");
            paris.setCountry(countryService.findByName("France"));
            townRepository.save(paris);
            Town strasbourg = new Town("Strasbourg","Strasbourg, German Strassburg, city, capital of Bas-Rhin département, Grand Est région, eastern France. It lies 2.5 miles (4 km) west of the Rhine River on the Franco-German frontier. Confluence of the branches of the Ill River, Strasbourg, Grand Est région, France.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881864/download_19_kmul69.jpg");
            strasbourg.setCountry(countryService.findByName("France"));
            townRepository.save(strasbourg);
            Town lyon = new Town("Lyon","Lyon, also spelled Lyons, capital of both the Rhône département and the Auvergne-Rhône-Alpes région, east-central France, set on a hilly site at the confluence of the Rhône and Saône rivers. It is the third largest city in France, after Paris and Marseille. ... Lyon was annexed to the kingdom of France in 1312.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881907/download_20_prdmuv.jpg");
            lyon.setCountry(countryService.findByName("France"));
            townRepository.save(lyon);
            Town andorra = new Town("Andorra la Vella","Andorra la Vella, (Catalan: “Andorra the Old”) , French Andorre la Vieille, Spanish Andorra la Vieja, town, capital of the independent coprincipality of Andorra. It lies near the confluence of the Valira and the Valira del Norte rivers in the narrow Gran Valira valley, on the southern slopes of the Pyrenees.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635881927/download_21_i2xopn.jpg");
            andorra.setCountry(countryService.findByName("Andorra"));
            townRepository.save(andorra);
            Town madrid = new Town("Madrid","Madrid is the capital of Spain, and is home to the Spanish Royal family as well as the Spanish Government. It is a modern metropolitan city and an economical and industrial center of Spain, and, with its population of nearly 3,5 million people, is also the biggest city in Spain.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882055/download_22_iqwzs4.jpg");
            madrid.setCountry(countryService.findByName("Spain"));
            townRepository.save(madrid);
            Town barcelona = new Town("Barcelona","Barcelona is the capital city of Catalonia, which is a region of Spain. Barcelona is the largest city on the Mediterranean coast. The city is between the rivers of Llobregat and Besòs, and south of the Pyrenees mountains. ... Barcelona is the second most populated city in Spain, and the tenth in the European Union.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635883786/istockphoto-1301579230-170667a_ndr4ub.jpg");
            barcelona.setCountry(countryService.findByName("Spain"));
            townRepository.save(barcelona);
            Town seville = new Town("Seville","Seville is the capital and largest city of the Spanish autonomous community of Andalusia and the province of Seville. It is situated on the lower reaches of the River Guadalquivir, in the southwest of the Iberian Peninsula. ... Seville was founded as the Roman city of Hispalis.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882189/download_24_mljjrq.jpg");
            seville.setCountry(countryService.findByName("Spain"));
            townRepository.save(seville);
            Town lisbon = new Town("Lisbon","Lisbon is the stunning capital city of Portugal, and is one of the most charismatic and vibrant cities in Europe. It is a city that effortlessly blends traditional heritage, with striking modernism and progressive thinking.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882225/download_25_hjfrii.jpg");
            lisbon.setCountry(countryService.findByName("Portugal"));
            townRepository.save(lisbon);
            Town porto = new Town("Porto","Porto, Portuguese Oporto, city and port, northern Portugal. ... World-famous for its port wine, Porto is Portugal's second largest city and is the commercial and industrial centre for the zone north of the Mondego River. The historic centre of Porto was designated a UNESCO World Heritage site in 1996.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882263/download_26_laghry.jpg");
            porto.setCountry(countryService.findByName("Portugal"));
            townRepository.save(porto);
            Town male = new Town("Male","Male is the capital and most populous city in the Republic of Maldives. With a population of 227,486 and an area of 8.30 square kilometres (3.20 sq mi), it is also one of the most densely populated cities in the world.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882346/download_27_dvrjea.jpg");
            male.setCountry(countryService.findByName("Maldives"));
            townRepository.save(male);
            Town istanbul = new Town("Istanbul","Istanbul is a world center of great importance in the past and present. ... Istanbul is Turkey's most populous city and its cultural and financial center. Located on both sides of the Bosphorus, the narrow strait between the Black Sea and the Marmara Sea, Istanbul bridges Asia and Europe both physically and culturally.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882412/Istanbul-skyline_k3evfm.jpg");
            istanbul.setCountry(countryService.findByName("Turkey"));
            townRepository.save(istanbul);
            Town london = new Town("London","London is the capital city of the United Kingdom. It is the U.K.'s largest metropolis and its economic, transportation, and cultural centre. London is also among the oldest of the world's great cities, with its history spanning nearly two millennia.",
                    "https://res.cloudinary.com/ivoto22/image/upload/v1635882449/download_28_clkm7j.jpg");
            london.setCountry(countryService.findByName("England"));
            townRepository.save(london);


        }
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name).orElse(null);
    }

    @Override
    public TownViewModel findById(Long id) {
        Town town1 = townRepository.findById(id).orElse(null);
        TownViewModel town = modelMapper.map(town1,TownViewModel.class);
        return town;
    }

    @Override
    public List<String> getAllTownsAsStrings() {

        return getAllTowns().stream()
                .map(t->{String townWithCountry = t.getName();
                    townWithCountry += " (";
                    townWithCountry += t.getCountryViewModel().getName();
                    townWithCountry +=") id:";
                    townWithCountry += t.getId();
                    return townWithCountry;

                })
                .collect(Collectors.toList());


    }

    @Override
    public List<TownViewModel> getAllTowns() {
        return townRepository.findAll().stream()
                .map(t-> {
                    TownViewModel townViewModel = modelMapper.map(t, TownViewModel.class);
                    townViewModel.setCountryViewModel(modelMapper.map(t.getCountry(), CountryViewModel.class));
                    return townViewModel;

                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Town> getAllTownsAsNormal() {
        List<Town> list = townRepository.findAll();
        return townRepository.findAll();
    }


}
