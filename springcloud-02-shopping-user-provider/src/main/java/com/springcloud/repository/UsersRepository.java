package com.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springcloud.entity.Users;

/**
 * 持久化层：用来定义对USER表进行操作的方法
 * 
 * @author asus
 *
 */
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
	/**
	 * 判断用户登录是否成功
	 * 
	 * @param userId
	 * @param userPassword
	 * @param jdictionId
	 * @return成功返回登录用户完整信息，失败返回null
	 */
	@Query("select new com.springcloud.entity.Users(u.userId,u.userName,u.userNumber,u.userPassword,u.userSex,u.userPhone,u.userSite,u.userBirthday,u.userEmail,u.userPhoto,u.jdictionId,u.userStatus) "
			+ "from Users u where u.userId=:userId and u.userPassword=:userPassword and u.jdictionId=:jdictionId and u.userStatus=0")
	public abstract Users login(@Param("userId") Integer userId, @Param("userPassword") String userPassword,
			@Param("jdictionId") Integer jdictionId);

	/**
	 * 修改USERS表中指定编号的用户状态
	 * 
	 * @param userId     用户编号
	 * @param userStatus 用户状态
	 * @return 修改成功，返回大于0 的整数，否则返回0
	 */
	@Modifying
	@Query("update Users set userStatus=:userStatus where userId=:userId")
	public abstract Integer updateStatus(@Param("userId") Integer userId, @Param("userStatus") Integer userStatus);

	/**
	 * 修改USERS表中指定USER_ID的用户信息
	 * 
	 * @param users 修改的用户信息
	 * @return 成功返回大于0 的整数，否则返回小于等于0的整数
	 */

	@Modifying
	@Query("update Users u set u.userNumber=:#{#users.userNumber},u.userSex=:#{#users.userSex},u.userPhone=:#{#users.userPhone},u.userBirthday=:#{#users.userBirthday},u.userEmail=:#{#users.userEmail},u.userSite=:#{#users.userSite} where u.userId=:#{#users.userId}")
	public abstract Integer update(@Param("users") Users users);

	/**
	 * 修改USER表中指定User_ID 的头像
	 * 
	 * @param users 修改的用户信息
	 * @return 成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userPhoto=:#{#users.userPhoto} where u.userId=:#{#users.userId}")
	public abstract Integer updatePhoto(@Param("users") Users users);

	/**
	 * 修改USER表中指定USER_ID的用户密码
	 * 
	 * @param users 修改的用户信息
	 * @return 成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userPassword=:#{#users.userPassword} where u.userId=:#{#users.userId}")
	public abstract Integer updatePassword(@Param("users") Users users);

	/**
	 * 修改USERS表中指定的USER_ID的用户昵称
	 * 
	 * @param users 修改的用户信息
	 * @return 成功返回大于0 的整数，否则返回小于等于0的整数
	 */
	@Modifying
	@Query("update Users u set u.userName=:#{#users.userName} where u.userId=:#{#users.userId}")
	public abstract Integer updateName(@Param("users") Users users);

}
