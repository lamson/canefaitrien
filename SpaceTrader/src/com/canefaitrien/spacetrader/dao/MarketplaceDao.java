// $codepro.audit.disable
package com.canefaitrien.spacetrader.dao;

import org.json.JSONException;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.canefaitrien.spacetrader.models.Marketplace;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MARKETPLACE.
*/
public class MarketplaceDao extends AbstractDao<Marketplace, Long> {

    public static final String TABLENAME = "MARKETPLACE";

    /**
     * Properties of entity Marketplace.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");

        public final static Property LastDock = new Property(1, Integer.class, "lastDock", false, "LAST_DOCK");

        public final static Property ItemStock = new Property(2, String.class, "itemStock", false, "ITEM_STOCK");

        public final static Property ItemBuyPrices = new Property(3, String.class, "itemBuyPrices", false, "ITEM_BUY_PRICES");

        public final static Property ItemSellPrices = new Property(4, String.class, "itemSellPrices", false, "ITEM_SELL_PRICES");
    };

    public MarketplaceDao(DaoConfig config) {
        super(config);
    }
    
    public MarketplaceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MARKETPLACE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'LAST_DOCK' INTEGER," + // 1: lastDock
                "'ITEM_STOCK' TEXT," + // 2: itemStock
                "'ITEM_BUY_PRICES' TEXT," + // 3: itemBuyPrices
                "'ITEM_SELL_PRICES' TEXT);"); // 4: itemSellPrices
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MARKETPLACE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Marketplace entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer lastDock = entity.getLastDock();
        if (lastDock != null) {
            stmt.bindLong(2, lastDock);
        }
 
        String itemStock = entity.getStringItemStock();
        if (itemStock != null) {
            stmt.bindString(3, itemStock);
        }
 
        String itemBuyPrices = entity.getStringItemBuyPrices();
        if (itemBuyPrices != null) {
            stmt.bindString(4, itemBuyPrices);
        }
 
        String itemSellPrices = entity.getStringItemSellPrices();
        if (itemSellPrices != null) {
            stmt.bindString(5, itemSellPrices);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Marketplace readEntity(Cursor cursor, int offset) {
        Marketplace entity = null;
		try {
			entity = new Marketplace( //
			    cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
			    cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // lastDock
			    cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // itemStock
			    cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // itemBuyPrices
			    cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // itemSellPrices
			);
		} catch (JSONException e) {
			Log.e("MarketplaceDao", e.getMessage());			
		}
		
		if (entity==null) 
			Log.e("MarketplaceDao", "entity is null");	
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Marketplace entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLastDock(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        try {
			entity.setItemStock(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
			entity.setItemBuyPrices(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
	        entity.setItemSellPrices(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
		} catch (JSONException e) {
			Log.e("MarketplaceDao", e.getMessage());
		}
        
        
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Marketplace entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Marketplace entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
