package com.canefaitrien.spacetrader.presenters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.canefaitrien.spacetrader.R;
import com.canefaitrien.spacetrader.SpaceTraderApplication;
import com.canefaitrien.spacetrader.interfaces.IGameModel;
import com.canefaitrien.spacetrader.interfaces.IMarketPlaceView;
import com.canefaitrien.spacetrader.models.Controller;
import com.canefaitrien.spacetrader.models.Marketplace;
import com.canefaitrien.spacetrader.models.TradeGood;

public class MarketPlacePresenter {

	private static final String TAG = "MarketPresenter";
	private IMarketPlaceView mView;
	private Marketplace mMarket;
	private Controller data;

	public MarketPlacePresenter(IMarketPlaceView view) {
		mView = view;
		data = SpaceTraderApplication.getData();
		mMarket = data.getLocation().getMarketplace();
	}

	// public List<HashMap<String, String>> listStockItems(Context context,
	// LinearLayout content) {
	// dynamically add list views
	// for (int i = 0; i < view.length; i++) {
	// LinearLayout ll = new LinearLayout(context);
	// ll.setOrientation(LinearLayout.HORIZONTAL);
	// ll.setPadding(20, 10, 20, 10);
	// for (int j = 0; j < view[i].length; j++) {
	//
	// TextView tv = new TextView(context);
	// tv.setText(view[i][j]);
	// tv.setPadding(20, 5, 20, 5);
	// ll.addView(tv);
	//
	// }
	// content.addView(ll);
	// // JButton button = new JButton("Buy");
	// // button.addActionListener(new BuyListener(goods[i]));
	// // panel.add(button);
	// // button = new JButton("Sell");
	// // button.addActionListener(new SellListener(goods[i]));
	// // panel.add(button);
	// }
	//
	// LinearLayout ll = new LinearLayout(context);
	// ll.setOrientation(LinearLayout.HORIZONTAL);
	// ll.setPadding(20, 10, 20, 10);
	// TextView tv = new TextView(context);
	// tv.setText("Planet " + data.getLocation().getName());
	// tv.setPadding(20, 5, 20, 5);
	// ll.addView(tv);
	// content.addView(ll);
	//
	// ll = new LinearLayout(context);
	// ll.setOrientation(LinearLayout.HORIZONTAL);
	// ll.setPadding(20, 10, 20, 10);
	// tv = new TextView(context);
	// tv.setText("$" + data.getMoney());
	// tv.setPadding(20, 5, 20, 5);
	// ll.addView(tv);
	// content.addView(ll);
	// return ret;
	// }

	public List<HashMap<String, String>> populateStock(
			List<HashMap<String, String>> list) {

		TradeGood[] goods = TradeGood.values();

		// List<Item> ret = new ArrayList<Item>();

		list = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < goods.length; i++) {
			// ret.add(new Item(goods[i].toString(),
			// mMarket.getItemBuyPrices()[i],
			// data.getShip().getCargo()[i], mMarket.getItemStock()[i]));

			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("name", goods[i].toString());
			temp.put("price", String.valueOf(mMarket.getItemBuyPrices()[i]));
			temp.put("sellprice",
					String.valueOf(mMarket.getItemSellPrices()[i]));
			temp.put("owned", String.valueOf(data.getShip().getCargo()[i]));
			temp.put("stock", String.valueOf(mMarket.getItemStock()[i]));

			list.add(temp);
		}
		return list;

	}

	public void buyItem(int pos) throws Exception {
		data.buyGood(TradeGood.values()[pos]);
		updateStockList(mView.getStockList());
	}

	public void sellItem(int pos) throws Exception {
		// TODO Auto-generated method stub
		data.sellGood(TradeGood.values()[pos]);
		updateStockList(mView.getStockList());
	}

	public void updateStockList(List<HashMap<String, String>> list) {
		mView.setStockList(this.populateStock(list));
	}

	public void showOtherInfo() {
		mView.displayMoney(String.valueOf(data.getMoney()));
		mView.displayCargo(String.valueOf(data.getShip().getCargo().length));
	}

	public class Item {
		private String name;
		private int buyPrice;
		private int owned;
		private int stock;

		public Item(String name, int buyPrice, int owned, int Stock) {
			setName(name);
			setBuyPrice(buyPrice);
			setOwned(owned);
			setStock(stock);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getBuyPrice() {
			return buyPrice;
		}

		public void setBuyPrice(int buyPrice) {
			this.buyPrice = buyPrice;
		}

		public int getOwned() {
			return owned;
		}

		public void setOwned(int owned) {
			this.owned = owned;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

	}
}