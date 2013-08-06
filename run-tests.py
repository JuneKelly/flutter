import os
import subprocess

srv = subprocess.Popen(
    ['lein', 'with-profile', 'test', 'ring', 'server-headless'],
    stdout=subprocess.PIPE)

spec = subprocess.call(['lein', 'with-profile', 'test', 'spec'])
