package com.dijolapp.sportinteractive.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.sportinteractive.R
import com.dijolapp.sportinteractive.Utils.Utils
import org.json.JSONObject


class PlayerListApdater(var context: Context, var playerString: List<String>?) :
    RecyclerView.Adapter<PlayerListApdater.MyViewHolder>() {
    var utils: Utils? = null

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = itemView.findViewById(R.id.textView)
        var keeper_captain: TextView? = itemView.findViewById(R.id.keeper_captain)
        var cardview: CardView? = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.player_rv_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val response = JSONObject(playerString!![position])
        utils = Utils()

        val playername = response.get("Name_Full")
        if (utils!!.getjsonobject(response).Iscaptain == true && utils!!.getjsonobject(response).Iskeeper == true) {
            holder.keeper_captain!!.visibility = View.VISIBLE
            holder.keeper_captain!!.text = "c & wk"
        } else if (utils!!.getjsonobject(response).Iscaptain == true) {
            holder.keeper_captain!!.visibility = View.VISIBLE
            holder.keeper_captain!!.text = "c "
        } else if (utils!!.getjsonobject(response).Iskeeper == true) {
            holder.keeper_captain!!.visibility = View.VISIBLE
            holder.keeper_captain!!.text = "wk"
        } else {
            holder.keeper_captain!!.visibility = View.GONE
            holder.keeper_captain!!.text = ""
        }

        holder.textView!!.text = playername.toString()

        holder.cardview!!.setOnClickListener {
            val batting = response.get("Batting")
            val bowling = response.get("Bowling")
            utils!!.showloadingDialog(context,batting.toString(),bowling.toString(),playername.toString())
        }
    }

    override fun getItemCount(): Int {
        return playerString!!.size
    }
}