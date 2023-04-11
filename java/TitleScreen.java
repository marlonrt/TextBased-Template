public class TitleScreen extends AppCompatActivity {

    // Constant representing time interval for back button double-press
    private static final int timeInterval = 2000;

    private long backPressed;

    private MusicPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        // Initialize the music player and start playing the specified track
        musicPlayer = new MusicPlayer();
        musicPlayer.play(this, R.raw.ruined);

        // Retrieve the ImageView from the layout and load the title image into it using Glide
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(R.drawable.title)
                .into(imageView);
    }

    // Method to transition to the GameScreen activity when the "Start" button is pressed
    public void goGameScreen(View view){
        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }

    // Override the behavior of the back button to allow for double-press to exit the app
    @Override
    public void onBackPressed(){
        if(backPressed + timeInterval > System.currentTimeMillis()){
            // Call the default behavior to exit the app
            super.onBackPressed();
            // Finish all activities in the back stack to fully close the app
            finishAffinity();
            finish();
        }
        else{
            Toast.makeText(getBaseContext(), "Closing message.", Toast.LENGTH_SHORT).show();
        }
        backPressed = System.currentTimeMillis();
    }

}
