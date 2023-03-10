package org.serversmc.autorestart.utils;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    
    private static FileConfiguration config = null;
    
    public static Integer VERSION;
    
    private static FileConfiguration getConfig() {
        return config;
    }
    
    public static void setConfig(FileConfiguration config) {
        Config.config = config;
        VERSION = getConfig().getInt("version", 0);
    }
    
    public static class MAIN {
    	public static class TIMESTAMP {
    		public static Boolean ENABLED() { return Config.getConfig().getBoolean("config.main.timestamp.enabled", false); }
    		public static String TIME() { return Config.getConfig().getString("config.main.timestamp.time", "0:00"); }
    	}
        public static Double INTERVAL() { return Config.getConfig().getDouble("config.main.interval", 6); }
        public static Boolean RESTARTSCRIPT() { return Config.getConfig().getBoolean("config.main.restart-script", false); }
        public static String SHUTDOWN() { return Config.getConfig().getString("config.main.shutdown", "&cServer Restarting! We will be back up any minute!"); }
    }
    
    public static class REMINDER {
        public static class ENABLED {
            public static Boolean MINUTES() { return Config.getConfig().getBoolean("config.reminder.enabled.minutes", true); }
            public static Boolean SECONDS() { return Config.getConfig().getBoolean("config.reminder.enabled.seconds", true); }
        }
        public static class TIMER {
            public static List<Integer> MINUTES() { return Config.getConfig().getIntegerList("config.reminder.timer.minutes"); }
            public static Integer SECONDS() { return Config.getConfig().getInt("config.reminder.timer.seconds", 5); }
        }
    }
    
    public static class BROADCAST {
        public static class ENABLED {
            public static Boolean MINUTES() { return Config.getConfig().getBoolean("config.broadcast.enabled.minutes", true); }
            public static Boolean SECONDS() { return Config.getConfig().getBoolean("config.broadcast.enabled.seconds", true); }
            public static Boolean TIME() { return Config.getConfig().getBoolean("config.broadcast.enabled.time", true); }
            public static Boolean STATUS() { return Config.getConfig().getBoolean("config.broadcast.enabled.status", true); }
            public static Boolean CHANGE() { return Config.getConfig().getBoolean("config.broadcast.change", true); }
        }
        public static class MESSAGES {
            public static String PREFIX() { return Config.getConfig().getString("config.broadcast.messages.prefix", "&f[&7AutoRestart&f] &e"); }
            public static List<String> MINUTES() { return Config.getConfig().getStringList("config.broadcast.messages.minutes"); }
            public static List<String> SECONDS() { return Config.getConfig().getStringList("config.broadcast.messages.seconds"); }
            public static List<String> TIME() { return Config.getConfig().getStringList("config.broadcast.messages.time"); }
            public static class STATUS {
                public static List<String> START() { return Config.getConfig().getStringList("config.broadcast.messages.status.start"); }
                public static List<String> PAUSE() { return Config.getConfig().getStringList("config.broadcast.messages.status.pause"); }
            }
            public static List<String> CHANGE() { return Config.getConfig().getStringList("config.broadcast.messages.change"); }
        }
    }
    
    public static class POPUPS {
        public static class ENABLED {
            public static Boolean MINUTES() { return Config.getConfig().getBoolean("config.popups.enabled.minutes", true); }
            public static Boolean SECONDS() { return Config.getConfig().getBoolean("config.popups.enabled.seconds", true); }
            public static Boolean TIME() { return Config.getConfig().getBoolean("config.popups.enabled.time", true); }
            public static Boolean STATUS() { return Config.getConfig().getBoolean("config.popups.enabled.status", true); }
            public static Boolean CHANGE() { return Config.getConfig().getBoolean("config.popups.enabled.change", true); }
        }
        
        public static class MESSAGES {
            public static class MINUTES {
                public static class TITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.minutes.title.text", "&cServer Restarting In"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.minutes.title.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.minutes.title.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.minutes.title.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.minutes.title.stay", 10); }
                }
                public static class SUBTITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.minutes.subtitle.text", "&f%m &cMinutes!"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.minutes.subtitle.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.minutes.subtitle.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.minutes.subtitle.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.minutes.subtitle.stay", 10); }
                }
            }
            
            public static class SECONDS {
                public static class TITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.seconds.title.text", "&cServer Restarting In"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.seconds.title.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.seconds.title.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.seconds.title.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.seconds.title.stay", 10); }
                }
                public static class SUBTITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.seconds.subtitle.text", "&f%s &cSeconds!"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.seconds.subtitle.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.seconds.subtitle.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.seconds.subtitle.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.seconds.subtitle.stay", 10); }
                }
            }
            
            public static class TIME {
                public static class TITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.time.title.text", "&cServer Restarting In"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.time.title.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.time.title.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.time.title.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.time.title.stay", 10); }
                }
                public static class SUBTITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.time.subtitle.text", "&f%h&cH &f%m&cM &f%s&cS!"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.time.subtitle.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.time.subtitle.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.time.subtitle.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.time.subtitle.stay", 10); }
                }
            }
            
            public static class STATUS {
                public static class START {
                    public static class TITLE {
                        public static String TEXT() { return Config.getConfig().getString("config.popups.messages.status.start.title.text", "&cAutoRestart has started!"); }
                        public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.status.start.title.delay", 0); }
                        public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.status.start.title.fadein", 10); }
                        public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.status.start.title.fadeout", 20); }
                        public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.status.start.title.stay", 10); }
                    }
                    public static class SUBTITLE {
                        public static String TEXT() { return Config.getConfig().getString("config.popups.messages.status.start.subtitl.texte", ""); }
                        public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.status.start.subtitle.delay", 0); }
                        public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.status.start.subtitle.fadein", 10); }
                        public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.status.start.subtitle.fadeout", 20); }
                        public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.status.start.subtitle.stay", 10); }
                    }
                }
                
                public static class PAUSE {
                    public static class TITLE {
                        public static String TEXT() { return Config.getConfig().getString("config.popups.messages.status.pause.title.text", "&cAutoRestart has been paused!"); }
                        public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.status.pause.title.delay", 0); }
                        public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.status.pause.title.fadein", 10); }
                        public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.status.pause.title.fadeout", 20); }
                        public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.status.pause.title.stay", 10); }
                    }
                    public static class SUBTITLE {
                        public static String TEXT() { return Config.getConfig().getString("config.popups.messages.status.pause.subtitle.text", ""); }
                        public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.status.pause.subtitle.delay", 0); }
                        public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.status.pause.subtitle.fadein", 10); }
                        public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.status.pause.subtitle.fadeout", 20); }
                        public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.status.pause.subtitle.stay", 10); }
                    }
                }
            }
            
            public static class CHANGE {
                public static class TITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.change.title.text", "&cServer Restarting In"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.change.title.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.change.title.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.change.title.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.change.title.stay", 10); }
                }
                public static class SUBTITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.change.subtitle.text", "&f%h&cH &f%m&cM &f%s&cS!"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.change.subtitle.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.change.subtitle.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.change.subtitle.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.change.subtitle.stay", 10); }
                }
            }
            
            public static class SHUTDOWN {
                public static class TITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.shutdown.title.text", "&cServer is now"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.shutdown.title.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.shutdown.title.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.shutdown.title.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.shutdown.title.stay", 10); }
                }
                public static class SUBTITLE {
                    public static String TEXT() { return Config.getConfig().getString("config.popups.messages.shutdown.subtitle.text", "&cRestarting!"); }
                    public static Integer DELAY() { return Config.getConfig().getInt("config.popups.messages.shutdown.subtitle.delay", 0); }
                    public static Integer FADEIN() { return Config.getConfig().getInt("config.popups.messages.shutdown.subtitle.fadein", 10); }
                    public static Integer STAY() { return Config.getConfig().getInt("config.popups.messages.shutdown.subtitle.fadeout", 20); }
                    public static Integer FADEOUT() { return Config.getConfig().getInt("config.popups.messages.shutdown.subtitle.stay", 10); }
                }
            }
        }
    }
    
    public static class COMMANDS {
        public static Boolean ENABLED() { return Config.getConfig().getBoolean("config.commands.enabled", false); }
        public static Integer TIME() { return Config.getConfig().getInt("config.commands.time", 5); }
        public static List<String> COMMANDSLIST() { return Config.getConfig().getStringList("config.commands.commands-list"); }
    }
    
    public static class UPDATE_FINDER {
    	public static Boolean ENABLED() { return Config.getConfig().getBoolean("config.update-finder.enabled", true); }
    	public static Integer TIME() { return Config.getConfig().getInt("config.update-finder.time", 3); }
    	public static List<String> MESSAGE() { return Config.getConfig().getStringList("config.update-finder.message"); }
    	public static String PLUGIN() { return Config.getConfig().getString("config.update-finder.plugin", "&f- &c%p"); }
    	public static class NOFIND {
    		public static Boolean ENABLED() { return Config.getConfig().getBoolean("config.update-finder.nofind.enabled", true); }
    		public static List<String> MESSAGE() { return Config.getConfig().getStringList("config.update-finder.nofind.message"); }
    	}
    }
    
    public static class MAXPLAYERS {
        public static Boolean ENABLED() { return Config.getConfig().getBoolean("config.max-players.enabled", false); }
        public static Integer AMOUNT() { return Config.getConfig().getInt("config.max-players.amount", 10); }
        public static Integer DELAY() { return Config.getConfig().getInt("config.max-players.delay", 10); }
        public static class MESSAGES {
            public static List<String> ALERT() { return Config.getConfig().getStringList("config.max-players.messages.alert"); }
            public static List<String> SHUTDOWN() { return Config.getConfig().getStringList("config.max-players.messages.shutdown"); }
        }
    }
    
}
