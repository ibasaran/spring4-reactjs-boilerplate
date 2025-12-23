import { createFileRoute } from '@tanstack/react-router'
import { ProfileForm } from '@/pages/settings'

export const Route = createFileRoute('/_authenticated/settings/')({
  component: ProfileForm,
})
