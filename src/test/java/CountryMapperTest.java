import com.cn.mapper.SysUserMapper;
import com.cn.mybatis.Country;
import com.cn.mybatis.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest {

    private static final Logger log = LoggerFactory.getLogger(CountryMapperTest.class);
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void testselectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Country> countryList = sqlSession.selectList("comn.cn.mybatis.CountryMapper"+"selectAll");
            printCountryList(countryList);
        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void testselectAll1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<SysUser> countryList = sqlSession.selectList("com.cn.mapper" +
                    ".SysUserMapper.selectAll");
            countryList.forEach(SysUser -> System.out.println(SysUser.toString()));

        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void testSelectByid() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectById(1L);
            System.out.println(sysUser.toString());
        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void selectUserAndRoleById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectUserAndRoleById(1001L);
            System.out.println(sysUser.toString());
        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
    @Test
    public void selectUserAndRoleById2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectUserAndRoleById2(1001L);
            System.out.println(sysUser.toString());
        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void selectUserAndRoleByIdSelect() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectUserAndRoleByIdSelect(1001L);
            Assert.assertNotNull(sysUser) ;
//            Assert.assertNotNull(sysUser.getRole()) ;
            log.info("1");
        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }


    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryName(), country.getCountryCode());
        }
    }


    @Test
    public void testL1Cache() {

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        try {
            SysUserMapper mapper = sqlSession1.getMapper(SysUserMapper.class);
            SysUser user1 = mapper.selectById(1L);
            System.out.println(user1);
//            sqlSession1.clearCache();
            SysUserMapper mapper2 = sqlSession1.getMapper(SysUserMapper.class);
//            SysUserMapper mapper2 = sqlSession2.getMapper(SysUserMapper.class);
            SysUser user2 = mapper2.selectById(1L);
            System.out.println(user2);

        } finally {
//不要忘记关闭 sqlSession
        sqlSession1.close();
        sqlSession2.close();
    }
    }


    @Test
    public void testL2Cache() {

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SysUserMapper mapper = sqlSession1.getMapper(SysUserMapper.class);
        SysUser user1 = mapper.selectById(1L);
        System.out.println(user1);
//        sqlSession1.close();
        SysUserMapper mapper2 = sqlSession2.getMapper(SysUserMapper.class);
        SysUser user2 = mapper2.selectById(1L);
        System.out.println(user2);
        sqlSession1.close();
        sqlSession2.close();

    }
}
