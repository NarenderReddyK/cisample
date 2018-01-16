-#!/usr/bin/env bash

if [ "$APPCENTER_BRANCH" == "master" ];
then
    ./gradlew publishApkRelease
else
	cd ../CITest
	mvn -DskipTests -P prepare-for-upload package
	appcenter test run appium --app "con_adityadasgupta/cisample" --devices "con_adityadasgupta/firstdeviceset" --app-path ../app/build/outputs/apk/app-release.apk  --test-series "dev" --locale "en_US" --build-dir target/upload --token 02085aad4964470fac15e75cb5324e3304f762f6
fi
