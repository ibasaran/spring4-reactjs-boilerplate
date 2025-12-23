import {
  Construction,
  LayoutDashboard,
  Monitor,
  Bug,
  ListTodo,
  FileX,
  HelpCircle,
  Lock,
  Bell,
  Package,
  Palette,
  ServerOff,
  Settings,
  Wrench,
  UserCog,
  UserX,
  Users,
  MessagesSquare,
  ShieldCheck,
  AudioWaveform,
  Command,
  GalleryVerticalEnd,
} from 'lucide-react'
import { type SidebarData } from '../types'

export const sidebarData: SidebarData = {
  user: {
    name: 'ismail başaran',
    email: 'basaran.ismaill@gmail.com',
    avatar: '/avatars/shadcn.jpg',
  },
  teams: [
    {
      name: 'Shadcn Admin',
      logo: Command,
      plan: 'Vite + ShadcnUI',
    },
    {
      name: 'Acme Inc',
      logo: GalleryVerticalEnd,
      plan: 'Enterprise',
    },
    {
      name: 'Acme Corp.',
      logo: AudioWaveform,
      plan: 'Startup',
    },
  ],
  navGroups: [
    {
      title: 'Genel',
      items: [
        {
          title: 'Anasayfa',
          url: '/',
          icon: LayoutDashboard,
        },
      ],
    },
    {
      title: 'Ayarlar',
      items: [
        {
          title: 'Ayarlar',
          icon: Settings,
          items: [
            {
              title: 'Kullanıcı Yönetimi',
              url: '/settings/user-management',
              icon: UserCog,
            },
          ],
        },
      ],
    },
  ],
}
