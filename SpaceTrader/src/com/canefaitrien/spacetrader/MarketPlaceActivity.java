package com.canefaitrien.spacetrader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.interfaces.IMarketPlaceView;
import com.canefaitrien.spacetrader.models.TradeGood;
import com.canefaitrien.spacetrader.presenters.MarketPlacePresenter;
import com.canefaitrien.spacetrader.presenters.MarketPlacePresenter.Item;

public class MarketPlaceActivity extends ListActivity implements
		IMarketPlaceView, OnClickListener {

	private final String TAG = "MarketPlace";
	MarketPlacePresenter mPresenter;

	private List<HashMap<String, String>> stockList = new ArrayList<HashMap<String, String>>();

	private int itemPos = 0;

	public MarketPlaceActivity() {
		mPresenter = new MarketPlacePresenter(this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_marketplace);

		Button btnBuy = (Button) findViewById(R.id.btn_buy);
		Button btnSell = (Button) findViewById(R.id.btn_sell);
		btnBuy.setOnClickListener(this);
		btnSell.setOnClickListener(this);

		mPresenter.updateStockList(stockList);
		mPresenter.showOtherInfo();
		this.displayMarket();

		// MarketAdapter adapter = new MarketAdapter(this,
		// R.layout.list_item_market, list);

	}

	public void displayMarket() {
		String[] from = new String[] { "name", "price", "sellprice", "owned",
				"stock" };
		int[] to = new int[] { R.id.good_name, R.id.good_price,
				R.id.good_sell_price, R.id.good_owned, R.id.good_stock };
		SimpleAdapter adapter = new SimpleAdapter(this, stockList,
				R.layout.list_item_market, from, to);
		setListAdapter(adapter);

	}

	public void displayMoney(String valueOf) {
		TextView tv = (TextView) findViewById(R.id.tv_money);
		tv.setText(valueOf);

	}

	public void displayCargo(String valueOf) {
		TextView tv = (TextView) findViewById(R.id.tv_cargo);
		tv.setText(valueOf);
	}

	public List<HashMap<String, String>> getStockList() {
		return stockList;
	}

	public void setStockList(List<HashMap<String, String>> stockList) {
		this.stockList = stockList;

	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		// Do something when a list item is clicked
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this, "You have chosen " + TradeGood.values()[position],
				Toast.LENGTH_LONG).show();

		itemPos = position;
	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btn_buy:
			try {
				mPresenter.buyItem(itemPos);
			} catch (Exception e) {
				Log.e(TAG, e.toString());
				Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.btn_sell:
			try {
				mPresenter.sellItem(itemPos);
			} catch (Exception e) {
				Log.e(TAG, e.toString());
				Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			}
			break;
		}
		this.displayMarket();
		mPresenter.showOtherInfo();
	}

	public class MarketAdapter extends ArrayAdapter<Item> {
		private List<Item> items;
		private ItemViewHolder itemHolder;

		private class ItemViewHolder {
			TextView name;
			TextView price;
			TextView owned;
			TextView stock;
		}

		public MarketAdapter(Context context, int tvResId, List<Item> list) {
			super(context, tvResId, list);
			this.items = list;
		}

		@Override
		public View getView(int pos, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.list_item_market, null);
				itemHolder = new ItemViewHolder();
				itemHolder.name = (TextView) v.findViewById(R.id.good_name);
				itemHolder.price = (TextView) v.findViewById(R.id.good_price);
				itemHolder.owned = (TextView) v.findViewById(R.id.good_owned);
				itemHolder.stock = (TextView) v.findViewById(R.id.good_stock);
				v.setTag(itemHolder);
			} else
				itemHolder = (ItemViewHolder) v.getTag();

			Item item = items.get(pos);

			if (item != null) {
				itemHolder.name.setText(item.getName());
				itemHolder.price.setText(item.getBuyPrice());
				itemHolder.owned.setText(item.getOwned());
				itemHolder.stock.setText(item.getStock());
			}

			return v;
		}
	}

}
