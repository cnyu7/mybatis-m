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
    public void selectAllUserAndRoles() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = mapper.selectAllUserAndRoles();
            Assert.assertNotNull(sysUsers);
            sysUsers.forEach(System.out::println);
        } finally {
//不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

}
