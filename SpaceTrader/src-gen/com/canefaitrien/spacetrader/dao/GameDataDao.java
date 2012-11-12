package com.canefaitrien.spacetrader.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.SqlUtils;

import com.canefaitrien.spacetrader.dao.GameData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table GAME_DATA.
*/
public class GameDataDao extends AbstractDao<GameData, Long> {

    public static final String TABLENAME = "GAME_DATA";

    /**
     * Properties of entity GameData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Difficulty = new Property(2, String.class, "difficulty", false, "DIFFICULTY");
        public final static Property Money = new Property(3, Integer.class, "money", false, "MONEY");
        public final static Property CurrentPlanet = new Property(4, String.class, "currentPlanet", false, "CURRENT_PLANET");
        public final static Property Turn = new Property(5, Integer.class, "turn", false, "TURN");
        public final static Property Date = new Property(6, java.util.Date.class, "date", false, "DATE");
        public final static Property PersonId = new Property(7, Long.class, "personId", false, "PERSON_ID");
    };

    private DaoSession daoSession;


    public GameDataDao(DaoConfig config) {
        super(config);
    }
    
    public GameDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'GAME_DATA' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'NAME' TEXT," + // 1: name
                "'DIFFICULTY' TEXT," + // 2: difficulty
                "'MONEY' INTEGER," + // 3: money
                "'CURRENT_PLANET' TEXT," + // 4: currentPlanet
                "'TURN' INTEGER," + // 5: turn
                "'DATE' INTEGER," + // 6: date
                "'PERSON_ID' INTEGER);"); // 7: personId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GAME_DATA'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GameData entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String difficulty = entity.getDifficulty();
        if (difficulty != null) {
            stmt.bindString(3, difficulty);
        }
 
        Integer money = entity.getMoney();
        if (money != null) {
            stmt.bindLong(4, money);
        }
 
        String currentPlanet = entity.getCurrentPlanet();
        if (currentPlanet != null) {
            stmt.bindString(5, currentPlanet);
        }
 
        Integer turn = entity.getTurn();
        if (turn != null) {
            stmt.bindLong(6, turn);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(7, date.getTime());
        }
 
        Long personId = entity.getPersonId();
        if (personId != null) {
            stmt.bindLong(8, personId);
        }
    }

    @Override
    protected void attachEntity(GameData entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public GameData readEntity(Cursor cursor, int offset) {
        GameData entity = new GameData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // difficulty
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // money
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // currentPlanet
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // turn
            cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)), // date
            cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7) // personId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GameData entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDifficulty(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMoney(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setCurrentPlanet(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTurn(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setDate(cursor.isNull(offset + 6) ? null : new java.util.Date(cursor.getLong(offset + 6)));
        entity.setPersonId(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GameData entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(GameData entity) {
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
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getPersonDao().getAllColumns());
            builder.append(" FROM GAME_DATA T");
            builder.append(" LEFT JOIN PERSON T0 ON T.'PERSON_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected GameData loadCurrentDeep(Cursor cursor, boolean lock) {
        GameData entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Person person = loadCurrentOther(daoSession.getPersonDao(), cursor, offset);
        entity.setPerson(person);

        return entity;    
    }

    public GameData loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<GameData> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<GameData> list = new ArrayList<GameData>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<GameData> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<GameData> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
