#!/usr/bin/env bash

#####
# Script to install JarPM on Debian Linux, assuming the user is running as root
#
# Copyright 2019 Landon Gravat, All Rights Reserved.
#####

function get_download_url {
	wget -q -nv -O- https://api.github.com/repos/$1/$2/releases/latest 2>/dev/null |  jq -r '.assets[].browser_download_url'
}

