@echo off
pushd %~dp0
title %0
echo ���hfs.exe ���Ҽ��˵�"��ҳ����(Q)"
reg add HKCR\*\shell\3Http /ve /d ��ҳ����^(^&Q^) /f>NUL
reg add HKCR\*\shell\3Http\Command /ve /d "\"%cd%\hfs.exe\" \"%%1\"" /f>NUL

reg add HKCR\Folder\shell\2Http /ve /d ��ҳ����^(^&Q^) /f>NUL
reg add HKCR\Folder\shell\2Http\Command /ve /d "\"%cd%\hfs.exe\" \"%%1\"" /f>NUL

popd