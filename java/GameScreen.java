public class GameScreen extends AppCompatActivity {

    // Fields
    private static final int timeInterval = 2000;
    private long backPressed;
    private String buttonPhrase = "buttonPhrase";
    private final Story story = new Story(this);

    // Admob
    AdView mAdView;
    private InterstitialAd mInterstitialAd;

    // UI elements
    ImageView image;
    TextView textCenter, historic;
    Button button1, button2, interst;

    // Lifecycle methods
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Initialize Admob
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        // Load banner ad
        LoadBanner();

        // Load interstitial ad
        setAds();

        // Load image with Glide
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(R.drawable.gif)
                .into(imageView);

        // Initialize UI elements and set button click listeners
        textCenter = findViewById(R.id.gameTextCenter);
        image = findViewById(R.id.ImageRpg);
        button1 = findViewById(R.id.choiceButton1);
        button2 = findViewById(R.id.choiceButton2);
        interst = findViewById(R.id.showAds);
        historic = findViewById(R.id.historic);

        button1.setTransformationMethod(null);
        button2.setTransformationMethod(null);
        interst.setTransformationMethod(null);
        textCenter.setTransformationMethod(null);

        // Load initial story content
        story.wolf();
    }

    @Override
    public void onBackPressed() {
        if (backPressed + timeInterval > System.currentTimeMillis()) {
            super.onBackPressed();
            finishAffinity();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Closing message.", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }

    // Admob methods
    void LoadBanner() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void setAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.interst_test), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;
            }
        });
    }

    // Button click listeners
    public void button1 (View view){
        String textM = button1.getText().toString();
        story.selectPosition(story.nextPosition1);

    }
    public void button2 (View view){
        String textM = button2.getText().toString();
        story.selectPosition(story.nextPosition2);

    }

    public void interst(View view) {
        story.selectPosition(story.nextPositionInterst);
    }
}
