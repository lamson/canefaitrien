package ;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;

import .Person;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table PERSON.
*/
public class PersonDao extends AbstractDao<Person, Long> {

    public static final String TABLENAME = "PERSON";

    /**
     * Properties of entity Person.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property PilotPts = new Property(2, Integer.class, "pilotPts", false, "PILOT_PTS");
        public final static Property FighterPts = new Property(3, Integer.class, "fighterPts", false, "FIGHTER_PTS");
        public final static Property TraderPts = new Property(4, Integer.class, "traderPts", false, "TRADER_PTS");
        public final static Property EngineerPts = new Property(5, Integer.class, "engineerPts", false, "ENGINEER_PTS");
    };


    public PersonDao(DaoConfig config) {
        super(config);
    }
    
    public PersonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PERSON' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'NAME' TEXT," + // 1: name
                "'PILOT_PTS' INTEGER," + // 2: pilotPts
                "'FIGHTER_PTS' INTEGER," + // 3: fighterPts
                "'TRADER_PTS' INTEGER," + // 4: traderPts
                "'ENGINEER_PTS' INTEGER);"); // 5: engineerPts
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PERSON'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Person entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Integer pilotPts = entity.getPilotPts();
        if (pilotPts != null) {
            stmt.bindLong(3, pilotPts);
        }
 
        Integer fighterPts = entity.getFighterPts();
        if (fighterPts != null) {
            stmt.bindLong(4, fighterPts);
        }
 
        Integer traderPts = entity.getTraderPts();
        if (traderPts != null) {
            stmt.bindLong(5, traderPts);
        }
 
        Integer engineerPts = entity.getEngineerPts();
        if (engineerPts != null) {
            stmt.bindLong(6, engineerPts);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Person readEntity(Cursor cursor, int offset) {
        Person entity = new Person( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // pilotPts
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // fighterPts
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // traderPts
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5) // engineerPts
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Person entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPilotPts(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setFighterPts(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setTraderPts(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setEngineerPts(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Person entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Person entity) {
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
