package id.ojogomaisantigo.jogodescolhas;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

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
