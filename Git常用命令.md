---

配置用户名

配置头像

始化本地仓库

```git
git init
```

查看仓库状态

```git
git status
```

移入暂存区 追踪文件
```git
git add ###.##
```

踢出文件 移出暂存区

```git
git rm --cached ###.##
```

  取消该文件上一次操作

```git
git reset HEAD ###.##
```

提交文件并填写日志

```git
git commit -m "#日志内容#"
```

查看提交日志

```git
git log
```

精简日志

```git
git log --pretty=oneline
```

精简图表日志

```git
git log --graph --pretty=oneline
```

追踪当前目录所有内容

```git
git add .
```

查看提交文件变动

```git
git diff Head -- ###.##
```

查看文件修改详情

```git
git show
```

查看文件内容

```git
cat ###.##
```

---

### 版本回退



指针**HEAD**往前寻址并回退一个版本

```git
git reset ---hard HEAD^
```

回退**#**个版本

```git
git reset --hard HEAD~#
```

指针精确寻址，回退当目标版本

```git
git reset --hard #文件唯一哈希值#
```

> copy = Ctrl + Insert； paste = Shift + Insert

 获取版本回退日志

```git
git reflog
```

---

### 文件删除



查看本地仓库文件目录

```git
git ls-files
```



