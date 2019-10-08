package com.hbwang.player.listener.impl;

import android.app.Activity;
import android.view.View;

import com.hbwang.player.R;
import com.hbwang.player.playerstatus.PlayerStatus;
import com.hbwang.player.playerstatus.PlayerValue;
import com.hbwang.player.view.mediacontroller.IHBWangMediaController;

import static com.hbwang.player.playerstatus.PlayerStatus.PLAYER_IS_FULL;

/**
 * ----------Dragon be here!----------/
 * Created by HBWang on 2019/3/4-10:55
 */
public class HBWangControllerOnClickListener implements View.OnClickListener{

    private IHBWangMediaController mIHBWangMediaController;
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.player_pause) {

            if (PlayerStatus.PLAY_STATUS == PlayerValue.PLAY_PLAYYING) {
                mIHBWangMediaController.pause();
            } else {
                mIHBWangMediaController.resume();
            }

        } else if (i == R.id.player_full) {
            PLAYER_IS_FULL = !PLAYER_IS_FULL;
            mIHBWangMediaController.playerFull((Activity)v.getContext());
        }

    }

    public View.OnClickListener bindController(IHBWangMediaController mIHBWangMediaController) {

        this.mIHBWangMediaController = mIHBWangMediaController;
        return this;
    }
}
