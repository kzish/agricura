package daoModels;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import net.centricdata.agricura.Models.Branches;
import net.centricdata.agricura.Models.SalesTeam;
import net.centricdata.agricura.Models.Weather;

import daoModels.BranchesDao;
import daoModels.SalesTeamDao;
import daoModels.WeatherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig branchesDaoConfig;
    private final DaoConfig salesTeamDaoConfig;
    private final DaoConfig weatherDaoConfig;

    private final BranchesDao branchesDao;
    private final SalesTeamDao salesTeamDao;
    private final WeatherDao weatherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        branchesDaoConfig = daoConfigMap.get(BranchesDao.class).clone();
        branchesDaoConfig.initIdentityScope(type);

        salesTeamDaoConfig = daoConfigMap.get(SalesTeamDao.class).clone();
        salesTeamDaoConfig.initIdentityScope(type);

        weatherDaoConfig = daoConfigMap.get(WeatherDao.class).clone();
        weatherDaoConfig.initIdentityScope(type);

        branchesDao = new BranchesDao(branchesDaoConfig, this);
        salesTeamDao = new SalesTeamDao(salesTeamDaoConfig, this);
        weatherDao = new WeatherDao(weatherDaoConfig, this);

        registerDao(Branches.class, branchesDao);
        registerDao(SalesTeam.class, salesTeamDao);
        registerDao(Weather.class, weatherDao);
    }
    
    public void clear() {
        branchesDaoConfig.clearIdentityScope();
        salesTeamDaoConfig.clearIdentityScope();
        weatherDaoConfig.clearIdentityScope();
    }

    public BranchesDao getBranchesDao() {
        return branchesDao;
    }

    public SalesTeamDao getSalesTeamDao() {
        return salesTeamDao;
    }

    public WeatherDao getWeatherDao() {
        return weatherDao;
    }

}
