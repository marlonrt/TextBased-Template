public class MusicPlayer {

    private MediaPlayer player;

    public void stop() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void play(Context context, int resourceId) {
        stop();

        player = MediaPlayer.create(context, resourceId);

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}
