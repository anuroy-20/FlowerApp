package com.example.flowerapp;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFlowers;
    private FlowerAdapter flowerAdapter;
    private TextView tvSelectedColorName;
    private LinearLayout headerBanner;

    private Map<String, List<FlowerModel>> flowerMap = new HashMap<>();
    private ColorTheme currentTheme;

    // Color themes
    private ColorTheme[] themes;

    // Color circle views
    private View[] colorViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide default action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initViews();
        initThemes();
        initFlowerData();
        setupColorListeners();

        // Default selection
        selectTheme(themes[0], colorViews[0]);
    }

    private void initViews() {
        tvSelectedColorName = findViewById(R.id.tvSelectedColorName);
        headerBanner = findViewById(R.id.headerBanner);
        rvFlowers = findViewById(R.id.rvFlowers);
        rvFlowers.setLayoutManager(new LinearLayoutManager(this));

        colorViews = new View[]{
            findViewById(R.id.colorRoseRed),
            findViewById(R.id.colorLavender),
            findViewById(R.id.colorSunflower),
            findViewById(R.id.colorOceanBlue),
            findViewById(R.id.colorEmerald),
            findViewById(R.id.colorCoral)
        };
    }

    private void initThemes() {
        themes = new ColorTheme[]{
            new ColorTheme("Rose Red", Color.parseColor("#E8304A"), Color.parseColor("#FFF0F2"), "#E8304A"),
            new ColorTheme("Lavender", Color.parseColor("#9B59B6"), Color.parseColor("#F5F0FB"), "#9B59B6"),
            new ColorTheme("Sunflower", Color.parseColor("#F39C12"), Color.parseColor("#FFFBF0"), "#F39C12"),
            new ColorTheme("Ocean Blue", Color.parseColor("#2980B9"), Color.parseColor("#F0F7FF"), "#2980B9"),
            new ColorTheme("Emerald", Color.parseColor("#27AE60"), Color.parseColor("#F0FBF4"), "#27AE60"),
            new ColorTheme("Coral", Color.parseColor("#FF6B6B"), Color.parseColor("#FFF5F5"), "#FF6B6B")
        };
    }

    private void initFlowerData() {
        int c1 = Color.parseColor("#E8304A");
        flowerMap.put("Rose Red", createList(
            new FlowerModel("🌹", "Red Rose", "The ultimate symbol of passionate love and romance.",
                "• Roses have been cultivated for over 5,000 years, originating in Asia.",
                "• A single red rose conveys deep love; a dozen means 'be mine forever'.",
                "• Rose petals are edible and used in teas, jams, and perfumes worldwide.",
                c1, "Rose Red", "#E8304A"),
            new FlowerModel("🌺", "Hibiscus", "A tropical beauty symbolizing delicate beauty and femininity.",
                "• Hibiscus tea is rich in vitamin C and popular in over 100 countries.",
                "• The flower opens and closes in a single day, symbolizing fleeting beauty.",
                "• It is the national flower of Malaysia and South Korea.",
                c1, "Rose Red", "#E8304A"),
            new FlowerModel("🌸", "Cherry Blossom", "A symbol of fleeting elegance and the beauty of life.",
                "• Japan's cherry blossom season, 'Hanami', draws millions of visitors each year.",
                "• The flowers bloom for only 1–2 weeks, representing life's transience.",
                "• There are over 200 varieties of cherry blossom trees worldwide.",
                c1, "Rose Red", "#E8304A"),
            new FlowerModel("🌹", "Amaryllis", "A bold red trumpet flower symbolizing pride and determination.",
                "• Amaryllis bulbs can bloom year after year with minimal care.",
                "• Each bulb can produce up to 6 large blooms per stem.",
                "• The name comes from Greek, meaning 'to sparkle'.",
                c1, "Rose Red", "#E8304A")
        ));

        int c2 = Color.parseColor("#9B59B6");
        flowerMap.put("Lavender", createList(
            new FlowerModel("💜", "Lavender", "A calming purple herb known for serenity and healing.",
                "• Lavender essential oil is the most widely used aromatherapy oil globally.",
                "• The Romans used lavender to scent their baths — 'lavare' means 'to wash'.",
                "• Bees love lavender; its nectar produces a distinctly flavored honey.",
                c2, "Lavender", "#9B59B6"),
            new FlowerModel("🌸", "Wisteria", "Cascading purple blooms that symbolize grace and romance.",
                "• Wisteria can live for over 100 years and grow to enormous sizes.",
                "• Some wisteria plants weigh over 150 tonnes when fully grown.",
                "• It blooms in stunning purple clusters that hang like nature's chandeliers.",
                c2, "Lavender", "#9B59B6"),
            new FlowerModel("🪷", "Lotus", "A spiritual flower representing purity and enlightenment.",
                "• The lotus rises from muddy water each morning, pristine and unblemished.",
                "• Lotus seeds can remain viable for over 1,300 years.",
                "• It is the national flower of India and Vietnam, symbolizing spiritual purity.",
                c2, "Lavender", "#9B59B6"),
            new FlowerModel("💐", "Allium", "A striking spherical purple bloom symbolizing unity and patience.",
                "• Alliums are closely related to onions and garlic — they share the same genus.",
                "• A single allium head can contain up to 2,000 tiny star-shaped flowers.",
                "• They naturally deter pests and are prized as companion plants in gardens.",
                c2, "Lavender", "#9B59B6")
        ));

        int c3 = Color.parseColor("#F39C12");
        flowerMap.put("Sunflower", createList(
            new FlowerModel("🌻", "Sunflower", "A radiant symbol of adoration, loyalty, and positivity.",
                "• Sunflowers follow the sun — a behavior called 'heliotropism'.",
                "• A single sunflower head is made up of up to 2,000 tiny flowers.",
                "• Sunflowers can absorb radiation from soil — they were planted near Chernobyl.",
                c3, "Sunflower", "#F39C12"),
            new FlowerModel("🌼", "Daisy", "A symbol of innocence, purity, and new beginnings.",
                "• The word 'daisy' comes from Old English 'daes eage' meaning 'day's eye'.",
                "• Daisies close at night and open again each morning with the sun.",
                "• There are over 20,000 species of daisy in the Asteraceae family.",
                c3, "Sunflower", "#F39C12"),
            new FlowerModel("🌕", "Marigold", "A bold golden flower representing warmth, creativity, and grief.",
                "• Marigolds are used in Mexican Día de los Muertos celebrations as offerings.",
                "• They naturally repel insects, making them a great companion plant in gardens.",
                "• Marigold petals are used as a natural dye for food and fabric.",
                c3, "Sunflower", "#F39C12"),
            new FlowerModel("🌼", "Black-Eyed Susan", "A cheerful golden wildflower symbolizing encouragement and justice.",
                "• Black-Eyed Susans are native to North America and attract butterflies and bees.",
                "• They are drought-tolerant and can thrive in poor soil conditions.",
                "• The flower is the state flower of Maryland and blooms from June to October.",
                c3, "Sunflower", "#F39C12")
        ));

        int c4 = Color.parseColor("#2980B9");
        flowerMap.put("Ocean Blue", createList(
            new FlowerModel("💐", "Blue Iris", "A majestic flower symbolizing wisdom, hope, and trust.",
                "• The iris was named after the Greek goddess of the rainbow.",
                "• Blue irises are among the rarest flower colors in nature.",
                "• Iris roots (orris root) are used in perfumery as a fixative.",
                c4, "Ocean Blue", "#2980B9"),
            new FlowerModel("🫐", "Hydrangea", "Lush, full blooms representing heartfelt emotion and gratitude.",
                "• Hydrangea color changes based on soil pH — acidic soil produces blue blooms.",
                "• A single hydrangea flower cluster can contain hundreds of tiny florets.",
                "• In Japan, they symbolize apology and are given to ask for forgiveness.",
                c4, "Ocean Blue", "#2980B9"),
            new FlowerModel("🌀", "Morning Glory", "Vibrant blue flowers symbolizing affection and new beginnings.",
                "• Morning glories bloom in the morning and wilt by the afternoon.",
                "• They can grow up to 15 feet in a single growing season.",
                "• In Japan, morning glories are celebrated in annual flower festivals.",
                c4, "Ocean Blue", "#2980B9"),
            new FlowerModel("💙", "Delphiniums", "Tall spires of vivid blue blooms symbolizing openness and positivity.",
                "• Delphiniums are one of the few truly blue flowers in the plant kingdom.",
                "• They can grow up to 6 feet tall, making them dramatic garden backdrops.",
                "• All parts of the delphinium plant are toxic if ingested.",
                c4, "Ocean Blue", "#2980B9")
        ));

        int c5 = Color.parseColor("#27AE60");
        flowerMap.put("Emerald", createList(
            new FlowerModel("🌿", "Green Orchid", "An extraordinarily rare bloom symbolizing nature's finest rarity.",
                "• True green orchids are among the rarest flowers in the world.",
                "• Orchids are the largest family of flowering plants with 28,000 species.",
                "• Some orchids can live for 100 years when properly cared for.",
                c5, "Emerald", "#27AE60"),
            new FlowerModel("☘️", "Shamrock Blossom", "Small white flowers on lucky three-leaf clovers.",
                "• Only one in 10,000 clovers has four leaves — hence the 'lucky' status.",
                "• Clover fixes nitrogen in soil, naturally fertilizing the ground around it.",
                "• Shamrocks were used by St. Patrick to explain the Holy Trinity.",
                c5, "Emerald", "#27AE60"),
            new FlowerModel("🌱", "Jade Vine", "An endangered tropical flower of stunning jade-green color.",
                "• The Jade Vine is critically endangered and found only in the Philippines.",
                "• Its claw-shaped flowers glow an eerie turquoise in the dark forest.",
                "• It is pollinated exclusively by bats, which hang upside down to feed.",
                c5, "Emerald", "#27AE60"),
            new FlowerModel("🌿", "Bells of Ireland", "Elegant green bell-shaped blooms symbolizing good luck and fortune.",
                "• Despite the name, Bells of Ireland are actually native to the Middle East.",
                "• The green 'bells' are actually the calyx, not the petals of the flower.",
                "• They are popular in floral arrangements for St. Patrick's Day celebrations.",
                c5, "Emerald", "#27AE60")
        ));

        int c6 = Color.parseColor("#FF6B6B");
        flowerMap.put("Coral", createList(
            new FlowerModel("🌸", "Coral Peony", "A symbol of romance, prosperity, and good fortune.",
                "• Peonies are one of the longest-used flowers in Eastern culture, for 2,000 years.",
                "• A single peony bloom can hold up to 100 ruffled petals.",
                "• In China, the peony is called the 'king of flowers' and symbolizes royalty.",
                c6, "Coral", "#FF6B6B"),
            new FlowerModel("🌷", "Coral Tulip", "A tulip in warm coral tones symbolizing warmth and caring.",
                "• Tulips originally came from Central Asia, not the Netherlands.",
                "• At the height of 'Tulip Mania' in 1637, one bulb cost more than a house.",
                "• A tulip petal is edible and can be used as a substitute for onion.",
                c6, "Coral", "#FF6B6B"),
            new FlowerModel("🏵️", "Coral Dahlia", "A spectacular flower symbolizing elegance and inner strength.",
                "• Dahlias are native to Mexico and were once used as a food source by the Aztecs.",
                "• There are over 42 species and 57,000 registered cultivars of dahlia.",
                "• The dahlia is the national flower of Mexico.",
                c6, "Coral", "#FF6B6B"),
            new FlowerModel("🌺", "Coral Zinnia", "A vibrant coral bloom symbolizing endurance and lasting affection.",
                "• Zinnias are one of the easiest flowers to grow from seed in any garden.",
                "• They bloom continuously from summer until the first frost of the season.",
                "• NASA grew zinnias aboard the International Space Station in 2016.",
                c6, "Coral", "#FF6B6B")
        ));
    }

    private List<FlowerModel> createList(FlowerModel... models) {
        List<FlowerModel> list = new ArrayList<>();
        for (FlowerModel m : models) list.add(m);
        return list;
    }

    private void setupColorListeners() {
        for (int i = 0; i < colorViews.length; i++) {
            final int index = i;
            colorViews[i].setOnClickListener(v -> selectTheme(themes[index], colorViews[index]));
        }
    }

    private void selectTheme(ColorTheme theme, View selectedView) {
        currentTheme = theme;

        // Update header
        headerBanner.setBackgroundColor(theme.getPrimaryColor());
        tvSelectedColorName.setText(theme.getName() + " Theme • " + theme.getHexCode());

        // Reset all color circle borders (remove ring)
        for (View v : colorViews) {
            GradientDrawable bg = new GradientDrawable();
            bg.setShape(GradientDrawable.OVAL);
            // Find the right color for each button
            int idx = getIndexOfView(v);
            if (idx >= 0) {
                bg.setColor(themes[idx].getPrimaryColor());
            }
            v.setBackground(bg);
            v.setScaleX(1.0f);
            v.setScaleY(1.0f);
        }

        // Highlight selected circle with white ring
        GradientDrawable selectedBg = new GradientDrawable();
        selectedBg.setShape(GradientDrawable.OVAL);
        selectedBg.setColor(theme.getPrimaryColor());
        selectedBg.setStroke(5, Color.WHITE);
        selectedView.setBackground(selectedBg);
        selectedView.animate().scaleX(1.15f).scaleY(1.15f).setDuration(200).start();

        // Update flowers list
        List<FlowerModel> flowers = flowerMap.get(theme.getName());
        if (flowers == null) flowers = new ArrayList<>();

        if (flowerAdapter == null) {
            flowerAdapter = new FlowerAdapter(this, flowers, theme.getPrimaryColor());
            rvFlowers.setAdapter(flowerAdapter);
        } else {
            flowerAdapter.updateData(flowers, theme.getPrimaryColor());
        }
    }

    private int getIndexOfView(View v) {
        for (int i = 0; i < colorViews.length; i++) {
            if (colorViews[i] == v) return i;
        }
        return -1;
    }
}
