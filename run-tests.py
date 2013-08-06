import subprocess
import pexpect
import time


print '<>> Starting test server and running specs...'

srv = pexpect.spawn('lein with-profile test trampoline ring server-headless')

time.sleep(5)

subprocess.call(' '.join(['lein', 'with-profile', 'test', 'spec']),
                shell=True)

print '<<>>'

srv.terminate()
srv.wait()
print '<>> Test server stopped...'
