# pluginDemo
- 一个gradle插件Demo
- 打包到本地
- 插件在APP的测试
- 上传到maven
- 上传到gradle

------

### 打包到本地
- 执行`plugin`的任务`tasks` -> `upload` -> `uploadArchives`
### 上传到maven
- 配置`local.properties`文件
```
# 用户名和key，需要在jcenter上获取
BINTRAY_USER = ****
BINTRAY_KEY=****************
```
- 执行`plugin`的任务`tasks` -> `other` -> `install`
- 执行`plugin`的任务`tasks` -> `publishing` -> `bintrayUpload`
- 打开jcenter网站，发布
### 上传到gradle
- 配置可参考[官方文档](https://plugins.gradle.org/docs/submit)
- 执行`plugin`的任务`tasks` -> `plugin portal` -> `publishPlugins`
