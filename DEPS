# This file contains dependencies for WebRTC that are not shared with Chromium.
# If you wish to add a dependency that is present in Chromium's src/DEPS or a
# directory from the Chromium checkout, you should add it to setup_links.py
# instead.

vars = {
  'version' : '0.1',
  'extra_gyp_flag': '-Dextra_gyp_flag=0',
  'chromium_git': 'https://chromium.googlesource.com',
  'chromium_revision': 'ba603a096944e16f5ac757c2a513b01a080cb3db',
}

# NOTE: Use http rather than https; the latter can cause problems for users
# behind proxies.
deps = {
  'leveldb':'https://github.com/google/leveldb.git@master',
  'ref/ReactiveViewModelTodo': 'https://github.com/YMC-Mobile/ReactiveViewModelTodo.git',
}

deps_os = {
  'win': {
    'src/third_party/winsdk_samples/src':
      Var('chromium_git') + '/external/webrtc/deps/third_party/winsdk_samples_v71@e71b549167a665d7424d6f1dadfbff4b4aad1589',
  },
}

hooks = [
  {
        # Check for legacy named top-level dir (named 'trunk').
        'name': 'check_root_dir_name',
        'pattern': '.',
        'action': ['python','-c',
                   ('import os,sys;'
                    'script = os.path.join("com_work","bootstrap.py");'
                    '_ = os.system("%s %s" % (sys.executable,script)) '
                    'if os.path.exists(script) else 0')],
  },
]


use_relative_paths = True

# git remote add --track master origin user@somesite.com:group/project.git   # git
# git remote add --track master origin user@172.16.1.100:group/project.git   # git w/IP
# git remote add --track master origin http://github.com/group/project.git   # http
# git remote add --track master origin http://172.16.1.100/group/project.git # http w/IP
# git remote add --track master origin /Volumes/Git/group/project/           # local
# git remote add --track master origin G:/group/project/                     # local, Win
